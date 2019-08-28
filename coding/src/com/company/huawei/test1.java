package com.company.huawei;

import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/8/28
 * @description
 */
public class test1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int res = 0;
        for(int a=(int)Math.sqrt(len);a<len;a++){
            for(int b=1;b<len;b++){
                int c = len-a-b;
                if(a>b&&a>c){
                   if(Math.pow(b,2)+Math.pow(c,2)==Math.pow(a,2)){
                       res++;
                   }
                }
                if(b>a&&b>c){
                    if(Math.pow(a,2)+Math.pow(c,2)==Math.pow(c,2)){
                        res++;
                    }
                }
                if(c>b&&c>a){
                    if(Math.pow(b,2)+Math.pow(a,2)==Math.pow(c,2)){
                        res++;
                    }
                }

            }
        }
        System.out.println(res);
    }
}
