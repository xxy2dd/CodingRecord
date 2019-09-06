package com.company.pdd.test19_2;

/**
 * @author xxy
 * @date 2019/9/1
 * @description
 */

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(";");
            String[] arr = input[0].split(",");
            List<Integer> even = new LinkedList<>();
            List<Integer> odd = new LinkedList<>();
            int N = Integer.parseInt(input[1]);
            for (int i = 0; i < arr.length; i++) {
                Integer temp = Integer.parseInt(arr[i]);
                if (temp % 2 == 0) {
                    even.add(temp);
                } else {
                    odd.add(temp);
                }
            }
            Collections.sort(even, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            Collections.sort(odd, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            int m = even.size();
            int n = odd.size();
            if (m >= N) {
                for (int i = 0; i < N; i++) {
                    if (i == N - 1) {
                        System.out.print(even.get(i));
                    } else {
                        System.out.print(even.get(i)+ ",");
                    }
                }
            } else {
                for (int i = 0; i < m; i++) {
                    System.out.print(even.get(i) + ",");
                }
                for(int j=0;j<N-m;j++){
                    if (j== N-m-1) {
                        System.out.print(odd.get(j));
                    } else {
                        System.out.print(odd.get(j) + ",");
                    }
                }
            }
        }
    }
}
