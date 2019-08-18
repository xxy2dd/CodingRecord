package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class Add {
    public int Add(int num1,int num2) {
        int temp;
        while(num2!=0){
            // 异或(相同为1，不同为0 ) 等同于不考虑进位相加, 1+1=0,1+0=1,0+1=1,0+0=0
            temp = num1^num2;
            // 与运算，然后左移1 只考虑进位的二进制位，1+1=1,1+0=0,0+1=0,0+0=0，等同于 与运算，并左移一位等价于 进位
            num2 = (num1&num2)<<1;
            // 重复上述两个步骤直至num2为0
            num1 = temp;
        }
        return num1;

    }
}
