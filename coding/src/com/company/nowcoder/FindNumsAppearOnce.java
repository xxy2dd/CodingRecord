package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * һ�����������������������֮�⣬
 * ���������ֶ����������Ρ�
 * ��д�����ҳ�������ֻ����һ�ε�����
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int diff = 0;
        // ���������������ͬ�������Ϊ0�����ʣ�µĽ����Ϊ����ֻ����һ�ε����ֵ����
        for(int num :array){
            diff ^= num;
        }
        // �Խ��ȡ����Ȼ��������
        // �������Ľ��1���ڵ����λ�������ֳַ����룬ÿһ���ﶼ����ֻ����һ�ε����ݺͳɶԳ��ֵ�����
        // ����������ÿһ�����������Էֱ��������ֻ����һ�ε�����
        diff &= -diff;
        for(int num:array){

            if((num&diff)==0){
                num1[0]^=num;
            }else{
                num2[0]^=num;
            }
        }
    }
}
