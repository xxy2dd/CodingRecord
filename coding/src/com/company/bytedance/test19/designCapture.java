package com.company.bytedance.test19;

import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 我叫王大锤，是一名特工。我刚刚接到任务：在字节跳动大街进行埋伏，抓捕恐怖分子孔连顺。和我一起行动的还有另外两名特工，我提议
 * 1. 我们在字节跳动大街的N个建筑中选定3个埋伏地点。
 * 2. 为了相互照应，我们决定相距最远的两名特工间的距离不超过D。
 * 我特喵是个天才! 经过精密的计算，我们从X种可行的埋伏方案中选择了一种。这个方案万无一失，颤抖吧，孔连顺！……
 * 万万没想到，计划还是失败了，孔连顺化妆成小龙女，混在cosplay的队伍中逃出了字节跳动大街。只怪他的伪装太成功了，就是杨过本人来了也发现不了的！
 * 请听题：给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。
 * 注意：
 * 1. 两个特工不能埋伏在同一地点
 * 2. 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用
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
