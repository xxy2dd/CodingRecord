package com.company.bytedance.test19;

import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * �ҽ����󴸣���һ���ع����Ҹոսӵ��������ֽ�������ֽ��������ץ���ֲ����ӿ���˳������һ���ж��Ļ������������ع���������
 * 1. �������ֽ�������ֵ�N��������ѡ��3������ص㡣
 * 2. Ϊ���໥��Ӧ�����Ǿ��������Զ�������ع���ľ��벻����D��
 * �������Ǹ����! �������ܵļ��㣬���Ǵ�X�ֿ��е����������ѡ����һ�֡������������һʧ�������ɣ�����˳������
 * ����û�뵽���ƻ�����ʧ���ˣ�����˳��ױ��С��Ů������cosplay�Ķ������ӳ����ֽ�������֡�ֻ������αװ̫�ɹ��ˣ����������������Ҳ���ֲ��˵ģ�
 * �����⣺����N����ѡ��Ϊ�����Ľ�����������D�������Զ�������ع���ľ�������ֵ���Լ���ѡ���������꣬����������ж��У��󴸵�С���ж��������ѡ��
 * ע�⣺
 * 1. �����ع����������ͬһ�ص�
 * 2. �����ع��ǵȼ۵ģ���ͬ����λ�����(A, B, C) ֻ��һ������������������ع�֮�以��λ�á����ظ�ʹ��
 */
public class designCapture {
    public static void main(String[] args) {
        int mod = 99997867;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int max_distance = scan.nextInt();
        int[] points = new int[n];
        for(int i = 0;i<n;i++){
            points[i] = scan.nextInt();
        }
        int count = 0;
        for(int j = 0;j<points.length;j++){
            if(j==1474){
                System.out.println(j);
            }
            int target = points[j]+max_distance;
            int left = j;
            int right = binarySearch(points,left+1,target);
            if(right-left-1>0){
                int a = (right-left-1)% mod;
                int b = (right-left)%mod;

                count += a*b/2;
            }
        }
        System.out.println(count%mod);
    }
    public static int binarySearch(int[] nums,int left,int target){
        if(nums==null||nums.length==0){
            return -1;
        }
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
}
