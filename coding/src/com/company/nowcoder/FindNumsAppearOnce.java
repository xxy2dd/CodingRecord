package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 一个整型数组里除了两个数字之外，
 * 其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字
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
