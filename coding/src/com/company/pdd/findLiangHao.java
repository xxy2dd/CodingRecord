package com.company.pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/7/27
 * @description
 */
public class findLiangHao {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        String str = scan.next();
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!list.contains(str.charAt(i))){
                list.add(str.charAt(i));
            }
        }
        String[][] res1 = findMinAndCost(str,list,k);
        if(res1[1][0] == null) {
            System.out.println(0);
            System.out.println(str);
        }else{
            int Min = Integer.parseInt(res1[0][1]);
            int Index = 0;
            for(int i = 1; i < res1.length ; i++) {
                if(Integer.parseInt(res1[i][1]) < Min) {
                    Min = Integer.parseInt(res1[i][1]);
                    Index = i;
                }else if(Integer.parseInt(res1[i][1]) == Min) {
                    for(int j = 0; j < n ; j++) {
                        if(res1[i][0].charAt(j) - res1[Index][0].charAt(j) > 0) {
                            break;
                        }else if(res1[i][0].charAt(j) - res1[Index][0].charAt(j) < 0) {
                            Min = Integer.parseInt(res1[i][1]);
                            Index = i;
                            break;
                        }
                    }
                }
            }
            System.out.println(Min);
            System.out.println(res1[Index][0]);
        }
    }
    public static String[][] findMinAndCost(String str, ArrayList<Character> list, int k){
        String[][] result = new String[list.size()][2];
        int[] b = new int[list.size()];
        char[] a = new char[str.length()];
        int max = 0;
        for(int i=0;i<list.size();i++){
            int count=0;
            for(int j = 0;j<str.length();j++){
                if(str.charAt(j)==list.get(i)){
                    count++;
                }
            }
            b[i] = count;
            max = Math.max(max,b[i]);
        }
        if(max>=k){
            result[0][0] = "0";
            result[0][1] = str;
        }else{
            for(int i=0;i<list.size();i++){
                int count = b[i];
                int min = 0;
                for(int c = 1;c<=9;c++){
                    for(int q = 0; q < str.length() ; q++) {
                        if(count==0 && str.charAt(q) - list.get(i) == c) {
                            a[q] = list.get(i);
                            min += Math.abs(str.charAt(q) - list.get(i));
                            count++;
                        }else if(count < k && a[q] != list.get(i)) {
                            a[q] = str.charAt(q);
                        }else if(count >= k && str.charAt(q) - list.get(i) > 0) {
                            break;
                        }
                    }
                    if(count < k) {
                        for(int m = str.length() - 1; m >= 0 ; m--) {
                            if(count < k && str.charAt(m) - list.get(i) < 0&& list.get(i) - str.charAt(m) == c) {
                                a[m] = list.get(i);
                                min += Math.abs(str.charAt(m) - list.get(i));
                                count++;
                            }else if(count >= k ) {
                                break;
                            }
                        }
                    }
                    if(count >= k & c == 1) {
                        for(int j = 0; j < str.length() ; j++) {
                            if(a[j] != list.get(i)) {
                                a[j] = str.charAt(j);
                            }
                        }
                        break;
                    }
                }
                result[i][1] = min + "";
                result[i][0] = new String(a);
            }
        }
        return result;
    }
}
