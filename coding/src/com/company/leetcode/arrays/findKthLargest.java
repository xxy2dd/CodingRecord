package com.company.leetcode.arrays;

import java.util.PriorityQueue;

/**
 * @author xxy
 * @date 2019/7/18
 * @description
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 思路：堆排或者快排
 * 堆排是稳定的  这里直接使用PriorityQueue优先队列实现堆
 */
public class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2)->o1-o2);
        for(int i =0;i<nums.length;i++){
            if(i<k){
                queue.add(nums[i]);
            }else{
                if(nums[i]>queue.peek()){
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();


    }
}
