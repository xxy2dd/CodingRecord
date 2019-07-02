package com.company.bytedance.designpattern;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;
    private Singleton( ) { }

    public static Singleton getUniqueInstance( ) {
        if ( uniqueInstance == null ) {
            synchronized ( Singleton.class ) {
                if ( uniqueInstance == null ) {
                    uniqueInstance = new Singleton( );
                }
            }
        }
        return uniqueInstance;
    }
}
