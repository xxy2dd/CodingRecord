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
        for(int num :array){
            diff ^= num;
        }
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
