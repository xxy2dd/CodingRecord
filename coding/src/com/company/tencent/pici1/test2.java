package com.company.tencent.pici1;

import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/8/17
 * @description
 */
public class test2 {
    static long cnt = 0;
    static int[] temp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = (int)Math.pow(2,n);
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        for(int j = 0;j<m;j++){
            int p = sc.nextInt();
            int q = (int)Math.pow(2,p);
            reverse(arr,q);
            cnt = 0;
            int res = InversePairs(arr);
            System.out.println(res);
        }
    }
    public static void reverse(int[] arr,int q){
        for(int i=0;i<arr.length;i=i+q){
            int start = i,end = i+q-1;
            while(start<end){
                int t = arr[start];
                arr[start] = arr[end];
                arr[end] = t;
                start++;
                end--;
            }
        }
    }
    public static int  InversePairs(int[] array){
        temp = new int[array.length];
        // ¹é²¢ÅÅÐò
        mergeSort(array,0,array.length-1);
        return (int)(cnt%1000000007);
    }
    public static void mergeSort(int[] nums,int l,int h){
        if(h-l<1){
            return;
        }
        int m = l+(h-l)/2;
        mergeSort(nums,l,m);
        mergeSort(nums,m+1,h);
        merge(nums,l,m,h);
    }

    public static void merge(int[] nums,int l,int m,int h){
        int i = l,j=m+1,k =l;
        while(i<=m||j<=h){
            if(i>m){
                temp[k] = nums[j++];
            }else if(j>h){
                temp[k] = nums[i++];
            }else if(nums[i]<nums[j]){
                temp[k] = nums[i++];
            }else{
                temp[k] = nums[j++];
                cnt += m-i+1;
            }
            k++;
        }

    }
}
