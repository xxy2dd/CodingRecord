package com.company.bytedance.designpattern;

/**
 * @author xxy
 * @date 2019/7/9
 * @description
 * 当 Singleton 类被加载时，静态内部类 SingletonHolder 没有被加载进内存。
 * 只有当调用 getUniqueInstance() 方法从而触发 SingletonHolder.INSTANCE 时
 * SingletonHolder 才会被加载，此时初始化 INSTANCE 实例，并且 JVM 能确保 INSTANCE 只被实例化一次。
 * 这种方式不仅具有延迟初始化的好处，而且由 JVM 提供了对线程安全的支持。
 */
public class Singleton2 {
    private Singleton2(){

    }
    private static class SingletonHolder{
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    public static Singleton2 getUniqueInstance(){
        return SingletonHolder.INSTANCE;
    }
}
