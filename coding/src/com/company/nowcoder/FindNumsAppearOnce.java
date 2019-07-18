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
        // 先异或，所有两两相同的异或结果为0，最后剩下的结果即为两个只出现一次的数字的异或
        for(int num :array){
            diff ^= num;
        }
        // 对结果取补码然后与运算
        // 根据异或的结果1所在的最低位，把数字分成两半，每一半里都还有只出现一次的数据和成对出现的数据
        // 这样继续对每一半相异或则可以分别求出两个只出现一次的数字
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
