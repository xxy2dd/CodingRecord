package com.company.bytedance.designpattern;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class Singleton {

    // volatile 保证指令不会重排序

    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }
    // 懒汉式-线程不安全
   /* public static Singleton getUniqueInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }*/

    // 饿汉式-线程安全
//    private static Singleton uniqueInstance = new Singleton();

    // 懒汉式-线程安全（性能不佳，会使阻塞时间过长）
   /* public static synchronized Singleton getUniqueInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }*/

    // 双重校验锁-线程安全

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
