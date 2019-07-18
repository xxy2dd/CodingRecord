package com.company.bytedance.designpattern;

/**
 * @author xxy
 * @date 2019/7/9
 * @description
 * �� Singleton �౻����ʱ����̬�ڲ��� SingletonHolder û�б����ؽ��ڴ档
 * ֻ�е����� getUniqueInstance() �����Ӷ����� SingletonHolder.INSTANCE ʱ
 * SingletonHolder �Żᱻ���أ���ʱ��ʼ�� INSTANCE ʵ�������� JVM ��ȷ�� INSTANCE ֻ��ʵ����һ�Ρ�
 * ���ַ�ʽ���������ӳٳ�ʼ���ĺô��������� JVM �ṩ�˶��̰߳�ȫ��֧�֡�
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
