package com.company.tencent.pici2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/9/1
 * @description
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
            }
        });
        int res = 0;
        for(int i=0;i<n;i++){
            res += arr[i][0]*i+arr[i][1]*(n-i-1);
        }
        System.out.println(res);
    }
}
