package com.company.sort;

/**
 * @author xxy
 * @date 2019/7/5
 * @description 归并排序：分治
 * 先将大数组分成几个小数组，再对小数组排序，然后将这些有序的数组合并成一个大的有序数组
 * 时间复杂度 O(nlogn) 稳定
 */
public class mergeSort {
    public static void main(String[] args) {
        mergeSort m = new mergeSort();
        int[] nums = {10, 4, 5, 10, 8, 13, 12, 1, 7};
//        m.sort(nums);
        m.mergesort2(nums);
        for (int i : nums) {
            System.out.println(i + " ");
        }
    }

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        mergesort(nums, 0, nums.length - 1);
    }

    // 常规思路 递归实现

    public void mergesort(int[] nums, int left, int right) {
        // 注意递归结束条件 left>=right
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        // 分治
        mergesort(nums, left, mid);
        mergesort(nums, mid + 1, right);
        // 合并
        merge(nums, left, mid, right);

    }

    // 非递归实现

    public void mergesort2(int[] nums){
        int n = nums.length,s = 2,i;
        while(s<=n){
            i=0;
            while(i+s<=n){
                merge(nums,i,i+s/2-1,i+s-1);
                // 每次扩大s步，从刚开始的两两一组到四四一组到八八一组...
                i+=s;
            }
            int mid = i+s/2-1;
            if(mid>=n){
                mid = n-1;
            }
            // 处理末尾残余部分
            merge(nums,i,mid,n-1);
            // 一次遍历结束 s 扩大两倍
            s *= 2;
        }
        // 最后再从头到尾处理一遍
        merge(nums,0,s/2-1,n-1);

    }

    public void merge(int[] nums, int left, int mid, int right) {

        // 临时数组存放合并和的结果
        int[] temp = new int[nums.length];
        int k = 0;
        int i = left;
        int j = mid + 1;
        // 注意循环条件
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 考虑 未放完的情况
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int m = 0; m < k; m++) {
            nums[m + left] = temp[m];
        }
    }
}
