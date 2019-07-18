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
            // 异或 等同于不考虑进位相加
            temp = num1^num2;
            // 与运算，然后左移1 只考虑进位的二进制位
            num2 = (num1&num2)<<1;
            // 重复上述两个步骤直至num2为0
            num1 = temp;
        }
        return num1;

    }
}
