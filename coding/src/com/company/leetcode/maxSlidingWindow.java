package com.company.leetcode;

import java.util.PriorityQueue;

/**
 * @author xxy
 * @date 2019/7/3
 * @description
 * 给定一个数组 nums，有一个大小为?k?的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口最大值。
 */
public class maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res= new int[nums.length-k+1];
        if(nums==null||nums.length<=1){
            return nums;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2)->o2-o1);
        for(int i=0;i<k;i++){
            queue.add(nums[i]);
        }
        res[0] = queue.peek();
        for(int i =0,j=i+k;j<nums.length;i++,j++){
            queue.remove(nums[i]);
            queue.add(nums[j]);
            res[i+1] = queue.peek();
        }
        return res;
    }
}
