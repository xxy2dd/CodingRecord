package com.company.wangyi.test19;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/8/3
 * @description
 */
public class getBaifenbi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for(int i= 0;i<n;i++){
            scores[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        for(int j = 0;j<q;j++){
            int x = sc.nextInt();
            String res  = getPercentage(x,scores);
            System.out.println(res);
        }
    }
    public static String getPercentage(int x,int[] scores){
        int score = scores[x-1];
        Arrays.sort(scores);
        int index = findNum(score,scores);
        DecimalFormat df = new DecimalFormat("######0.000000");
        String res ="";
        int len = scores.length;
        if(index!=-1){
            double p = index*1.0/scores.length;
            res = df.format(p);
        }
        return res;
    }
    public static int findNum(int num,int[]array){
        int left = 0,right = array.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(array[mid]==num){
                return mid;
            }
            else if(array[mid]<num){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;

    }
}
