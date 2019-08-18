package com.company.wangyi;

import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/8/3
 * @description
 * ����������
 * ��һ��һ����n(1 <= n <= 105)��
 * �ڶ���n����ai(1 <= ai <= 1000)����ʾ������������i���ж���ƻ��
 * ������һ����m(1 <= m <= 105)����ʾ��m��ѯ�ʡ�
 * ������m����qi����ʾС��ϣ��֪����qi��ƻ��������һ�ѡ�
 *
 * �������:
 * m�У���i�������qi��ƻ��������һ��
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
