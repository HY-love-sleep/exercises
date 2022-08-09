package demo;

/*

*/
public class SingleTon {
    private static volatile SingleTon uniqueInstance;

    private SingleTon() {
    }

    public static SingleTon getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (SingleTon.class) {
                if (uniqueInstance == null) {
                    /*
                       这段代码是分三段进行的
                       1、为uniqueInstance分配内存地址
                       2、初始化uniqueInstance
                       3、将uniqueInstance指向分配的内存地址
                       但是由于JVM有指令重排的特性，执行顺序可能变为1->3->2,这在单线程环境下不会出现问题
                       但是在多线程环境下会出现获得还没被初始化的实例；
                       例如线程T1 执行了 1和3，此时T2 调用getUniqueInstance后发现 uniqueInstance不为空，因此返回uniqueInstance，
                       但此时uniqueInstance还未被初始化
                       volatile用来禁止JVM指令重排
                    */
                    uniqueInstance = new SingleTon();
                }
            }
        }
        return uniqueInstance;
    }
}
