package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 给定一个数组A[0,1,...,n-1],
 * 请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Multiply {
    public int[] multiply(int[] A) {
        int len = A.length;
        if(len<=0){
            return null;
        }
        int [] B = new int[len];
        B[0] =1;
        for(int i = 1;i<len;i++){
            B[i] = B[i-1]*A[i-1];
        }
        int temp = 1;
        for(int j = len-2;j>=0;j--){
            temp *=A[j+1];
            B[j]*=temp;
        }
        return B;

    }
}
