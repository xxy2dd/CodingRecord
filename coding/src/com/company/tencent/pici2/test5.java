package com.company.tencent.pici2;

import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/9/1
 * @description
 */
public class test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        for(int i=0;i<t;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int count=0;
            for(int j=a;j<=b;j++){
                for(int q = 0;q<=j;q++){
                    int red = q;
                    for(int p=0;p<=k;p++){
                        int white = red*p;
                        if(red+white==j){
                            count++;
                        }
                    }
                }

            }
            System.out.println(count+1);
        }
    }
}
