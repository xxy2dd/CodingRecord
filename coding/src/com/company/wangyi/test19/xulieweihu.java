package com.company.wangyi.test19;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/8/3
 * @description
 */
public class xulieweihu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        int[] query = new int[m];
        for(int i= 0;i<n;i++){
            num[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++){
            query[i] = sc.nextInt();
        }
        Arrays.sort(num);
        for(int j = 0;j<m;j++){
            int index = findNum(query[j],num);
            System.out.println(n-index);
            for(int p =index;p<n;p++){
                num[p]=num[p]-1;
            }
        }
    }
    public static int findNum(int num,int[]array){
        int left = 0,right = array.length;
        while(left<right){
            int mid = left+(right-left)/2;
            if(array[mid]<num){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;

    }
}
