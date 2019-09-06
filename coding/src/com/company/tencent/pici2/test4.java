package com.company.tencent.pici2;

import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/9/1
 * @description
 */
public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int max = arr[0]*arr[0];
        for(int i=0;i<n;i++){
            int sum = arr[i];
            int min =arr[i];
            for(int j=i+1;j<n;j++){
                sum+=arr[j];
                if(arr[j]<min){
                    min = arr[j];
                }
                if(min*sum>max){
                    max = min*sum;
                }
            }
        }
        System.out.println(max);

    }
}
