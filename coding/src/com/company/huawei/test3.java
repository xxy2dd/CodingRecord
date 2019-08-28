package com.company.huawei;

import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/8/28
 * @description
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();

        int[] a = new int[len];
        int[] b = new int[len];
        //  ‰»Î¥¶¿Ì
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = sc.nextInt();
        }
        int[][] R = new int[a.length+1][b.length+1];

        for(int i=1;i<=a.length;i++){
            for(int j=1;j<=b.length;j++){
                if(a[i-1]==b[j-1]){
                    R[i][j] = R[i-1][j-1]+1;
                }else if(R[i-1][j]>R[i][j-1]){
                    R[i][j] = R[i-1][j];
                }else if(R[i-1][j]<R[i][j-1]){
                    R[i][j] = R[i][j-1];
                }else{
                    R[i][j] = R[i][j-1];
                }
            }
        }
        int maxLen = R[a.length][b.length];
        int res = len - maxLen;
        System.out.println(res);
    }
}
