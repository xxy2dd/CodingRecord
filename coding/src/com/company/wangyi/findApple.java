package com.company.wangyi;

import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/8/3
 * @description
 * 输入描述：
 * 第一行一个数n(1 <= n <= 105)。
 * 第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
 * 第三行一个数m(1 <= m <= 105)，表示有m次询问。
 * 第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
 *
 * 输出描述:
 * m行，第i行输出第qi个苹果属于哪一堆
 */
public class findApple {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] total = new int[n];
        int sum = 0;
        for(int i = 0;i<n;i++){
            total[i] = sum+sc.nextInt();
            sum = total[i];
        }
        int m = sc.nextInt();
        int[] query = new int[m];
        for(int i=0;i<m;i++){
            query[i] = sc.nextInt();
            int res = search(query[i],total);
            if(res>0){
                System.out.println(res);
            }
        }

    }
    public static int search(int num,int[] array){
        int left = 0,right = array.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(array[mid]<num){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        if(array[left]>=num){
            return left+1;
        }else{
            return right+1;
        }
    }
}
