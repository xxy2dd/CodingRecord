package com.company.bytedance.test19;

import java.util.*;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。
 * 为了使手串的色彩看起来不那么单调，金主要求，手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次（注意这里手串是一个环形）。
 * 手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，每个串珠用所包含的颜色分别有哪些。
 * 请你判断该手串上有多少种颜色不符合要求。
 * 即询问有多少种颜色在任意连续m个串珠中出现了至少两次。
 * 输入：
 * 第一行输入n，m，c三个数，用空格隔开。
 * (1 <= n <= 10000, 1 <= m <= 1000, 1 <= c <= 50) 接下来n行每行的第一个数num_i(0 <= num_i <= c)表示第i颗珠子有多少种颜色。
 * 接下来依次读入num_i个数字，每个数字x表示第i颗柱子上包含第x种颜色(1 <= x <= c)
 */
public class countsOfBeads {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int c = scan.nextInt();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            int num_i = scan.nextInt();
            for(int j = 0;j<num_i;j++){
                int color = scan.nextInt();
                List<Integer> list = new LinkedList<>();
                if(map.containsKey(color)){
                    list = map.get(color);
                }
                list.add(i+1);
                map.put(color,list);
            }
        }
        int count = 0;
        for(int k = 0;k<=c;k++){
            List<Integer> list =map.get(k);
            if(list!=null){
                for(int i=0;i<list.size()-1;i++){
                    if(list.size()>1&&(n+list.get(0)-list.get(list.size()-1))<m){
                        count++;
                        break;
                    }
                    if(list.get(i+1)-list.get(i)<m){
                        count++;
                        break;
                    }

                }
            }
        }
        System.out.println(count);
    }
}
