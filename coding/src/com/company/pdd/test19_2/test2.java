package com.company.pdd.test19_2;

import java.util.*;

/**
 * @author xxy
 * @date 2019/9/1
 * @description
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for(int m=0;m<n;m++){
            String A = sc.nextLine();
            String B = sc.nextLine();
            int len1 = A.length();
            int len2 = B.length();
            List<List<String>> res = new ArrayList<>();
            System.out.println("{");
            for(int i=0;i<len1;i++){
                boolean flag = false;
                for(int j=0;j<len2;j++){
                    if(A.charAt(i)==B.charAt(j)){
                        flag = true;
                        if(i<j){
                            System.out.print("r ");
                        }else{

                        }
                    }
                }
                if(!flag){
                    System.out.print("d ");
                }

            }
        }
    }
}
