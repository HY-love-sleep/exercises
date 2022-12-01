package leetcode.test;

import java.util.concurrent.ConcurrentHashMap;

public class SingleTon {
    private static volatile SingleTon uniqueInstance;

    private SingleTon() {};

    private static SingleTon getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (SingleTon.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingleTon();
                }
            }
        }
        return uniqueInstance;
    }
}