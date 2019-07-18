package com.company.bytedance.designpattern;

/**
 * @author xxy
 * @date 2019/7/9
 * @description
 * ��ʵ�ֿ��Է�ֹ���乥����
 * ������ʵ���У�ͨ�� setAccessible() �������Խ�˽�й��캯���ķ��ʼ�������Ϊ public��
 * Ȼ����ù��캯���Ӷ�ʵ�����������Ҫ��ֹ���ֹ�������Ҫ�ڹ��캯������ӷ�ֹ���ʵ�����Ĵ��롣
 * ��ʵ������ JVM ��ֻ֤��ʵ����һ�Σ���˲�����������ķ��乥����
 * ��ʵ���ڶ�����л������л�֮�󣬲���õ����ʵ����
 * ������ʵ����Ҫʹ�� transient ���������ֶΣ�����ʵ�����л��ͷ����л��ķ�����
 */
public enum Singleton3 {
    // Ψһʵ��
    INSTANCE;

    private String objName;

    public String getObjName(){
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args){
        // ��������
        Singleton3 firstSingleton = Singleton3.INSTANCE;
        firstSingleton.setObjName("firstName");
        System.out.println(firstSingleton.getObjName());
        Singleton3 secondSingleton = Singleton3.INSTANCE;
        secondSingleton.setObjName("secondName");
        System.out.println(firstSingleton.getObjName());
        System.out.println(secondSingleton.getObjName());

        // �����ȡʵ������
        try {
            Singleton3[] enumConstants = Singleton3.class.getEnumConstants();
            for (Singleton3 enumConstant : enumConstants) {
                System.out.println(enumConstant.getObjName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
