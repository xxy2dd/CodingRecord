package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        if (n==0 || n==1){
            return n;
        }
        int prev = 0;
        int curr = 1;
        for(int i = 1;i < n;i++){
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}
