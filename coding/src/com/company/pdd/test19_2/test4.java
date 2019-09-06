package com.company.pdd.test19_2;

import java.util.*;

/**
 * @author xxy
 * @date 2019/9/1
 * @description
 */
public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
       int p=0;
        for(int i=n;i>=1;i--){
            for(int j=m;j>=1;j--){
                if(p<k){
                    queue.add(i*j);
                    p++;
                }else{
                    if(i*j>queue.peek()){
                        queue.poll();
                        queue.add(i*j);
                    }
                }
            }
        }
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
       System.out.println(queue.peek());
    }
}
