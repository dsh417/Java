如果线程有竞争 || 偏向锁未开启
    线程访问synchronized锁会使用轻量级锁来抢占资源，以获得访问资格。

轻量级锁实现流程：
    线程进入synchronized(lock)代码块后，jvm分配一个BasicObjectLock对象：
        (在BasicLock中有一个markOop _displaced_header，这个属性用来存储lock锁对象的原始Mark Word)
    将锁对象的lock的Mark Word复制到BasicObjectLock的oop下
    构建一个无锁的Mark Word（其实就是lock的Mark Word，区别是状态无锁）储存到BasicLock的MarkOop _displaced_header字段。
    通过CAS将lock锁对象的Mark Word替换为这个BasicObjectLock锁对象的引用：
        替换成功：
            获得访问资格，轻量级锁抢占成功。
            *此时会将oop中的lock字段：设置为00（即轻量级锁，这个字段已经成为lock对象的锁状态了）
        替换失败：
            说明当前lock锁对象不是无锁，锁升级为重量级锁。
            *关于自旋：这是在重量级锁中实现的。
    （CAS流程：将lock锁对象的Mark Word复制过来后，通过比较这两者是否相同来决定是否获得轻量级锁）
        Q：每个线程来了都能成功？
        A：不是。每次CAS都会判断锁的状态，无锁下才会执行CAS，所以不存在多个线程获得锁的问题。
区别于偏向锁：
    偏向锁只能保证偏向同一个线程，其他线程只能用轻量级锁去抢占（除非触发了批量重偏向）
    轻量锁可以灵活释放

轻量级锁的释放：
    *偏向锁不是真正意义的释放->回顾，偏向锁释放的是线程的锁
    CAS操作，将BasicObjectLock的_displaced_header储存的锁对象Mark Word替换到lock锁对象中。
    CAS成功：
        轻量级锁释放完成（标志位是无锁01，无需其他设置）
    CAS失败：
        原因是发生了锁竞争。这里会出发锁膨胀，之后会调用重量级锁的释放锁方法完成释放。
        *失败分析：
            线程1获得了轻量级锁，这时候线程2来尝试获取轻量级锁失败，会触发锁膨胀逻辑，在重试过程中，如果当前所状态还是轻量级锁，线程2会修改锁对象的Mark Word设置为INFLATING状态。
            *多个锁膨胀中只能有一个线程来修改状态
            这时候lock锁对象的Mark Word在锁膨胀过程发生了变化，则轻量级锁CAS释放必然失败，因为线程栈帧的_displaced_header和锁对象的Mark Word已经不一样了。
            且：  线程1在持有锁期间，其他获取不到锁，升级为重量级锁的线程，在你释放的时候还需要将他们唤醒。

轻量锁和偏向锁的对比：
    加锁方式：
        偏向锁：
            把Thread ID保存在锁对象的Mark Word中
        轻量锁：
            每个线程栈帧分配个BasicObjectLock，把锁对象的Mark Word拷贝到oop里，然后把锁对象的Mark Word指针指向线程对象的BasicObjectLock。
            *设计原因：
                锁对象在竞争过程中可能会变化，但是每个线程的Mark Word不受影响，所以锁膨胀时，可以通过BasicObjectLoc和锁对象的Mark Word比较，
                以此判断线程是否被其他线程抢占过，如果有，就需要在轻量级锁的释放过程中，唤醒被阻塞的其他线程。

