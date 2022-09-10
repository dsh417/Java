package top.duanshuheng.jdk8.no2synchronized.no2test;

import org.openjdk.jol.info.ClassLayout;

public class BiasedLockExample {
    public static void main(String[] args) {
        BiasedLockExample example=new BiasedLockExample();
        System.out.println("加锁前");
        System.out.println(ClassLayout.parseInstance(example).toPrintable());
        synchronized(example){
            System.out.println("加锁后");
            System.out.println(ClassLayout.parseInstance(example).toPrintable());
        }
/*
                加锁前
        # WARNING: Unable to get Instrumentation. Dynamic Attach failed. You may add this JAR as -javaagent manually, or supply -Djdk.attach.allowAttachSelf
        # WARNING: Unable to attach Serviceability Agent. You can try again with escalated privileges. Two options: a) use -Djol.tryWithSudo=true to try with sudo; b) echo 0 | sudo tee /proc/sys/kernel/yama/ptrace_scope
        top.duanshuheng.no2.no2test.BiasedLockExample object internals:
        OFF  SZ   TYPE DESCRIPTION               VALUE
        0   8        (object header: mark)     0x0000000000000005 (biasable; age: 0)
        8   4        (object header: class)    0x00090040
        12   4        (object alignment gap)
        Instance size: 16 bytes
        Space losses: 0 bytes internal + 4 bytes external = 4 bytes total

        加锁后
        top.duanshuheng.no2.no2test.BiasedLockExample object internals:
        OFF  SZ   TYPE DESCRIPTION               VALUE
        0   8        (object header: mark)     0x0000000148010005 (biased: 0x0000000000520040; epoch: 0; age: 0)
        8   4        (object header: class)    0x00090040
        12   4        (object alignment gap)
        Instance size: 16 bytes
        Space losses: 0 bytes internal + 4 bytes external = 4 bytes total

*/

    }
}
