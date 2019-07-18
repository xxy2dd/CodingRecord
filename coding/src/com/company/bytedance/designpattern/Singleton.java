package com.company.bytedance.designpattern;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class Singleton {

    // volatile ��ָ֤���������

    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }
    // ����ʽ-�̲߳���ȫ
   /* public static Singleton getUniqueInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }*/

    // ����ʽ-�̰߳�ȫ
//    private static Singleton uniqueInstance = new Singleton();

    // ����ʽ-�̰߳�ȫ�����ܲ��ѣ���ʹ����ʱ�������
   /* public static synchronized Singleton getUniqueInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }*/

    // ˫��У����-�̰߳�ȫ

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
