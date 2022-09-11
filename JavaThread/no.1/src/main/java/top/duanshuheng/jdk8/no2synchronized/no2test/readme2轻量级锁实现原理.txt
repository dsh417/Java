如果线程有竞争 || 偏向锁未开启
    线程访问synchronized锁会使用轻量级锁来抢占资源，以获得访问资格。

轻量级锁实现流程：
    线程进入synchronized(lock)代码块后，jvm分配一个BasicObjectLock对象、
    *在BasicLock中有一个markOop_displaced_header，这个属性用来存储lock锁对象的原始Mark Word。
    构建一个无锁的Mark Word（其实就是lock的Mark Word，区别是状态无锁），把这个无锁的Mark Word设置到_displaced_header字段。
    通过CAS将lock锁对象的Mark Word指向BasicObjectLock的指针：
        替换成功：
            获得访问资格，轻量级锁抢占成功。
        替换失败：
            说明当前lock锁对象不是无锁，锁升级为重量级锁。
    （事实上就是通过CAS替换锁对象指向BasicObjectLock的指针）

区别于偏向锁：
    偏向锁只能保证偏向同一个线程，其他线程只能用轻量级锁去抢占（除非触发了批量重偏向）
    轻量锁可以灵活释放


