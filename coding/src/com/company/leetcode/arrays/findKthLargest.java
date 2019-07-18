package com.company.leetcode.arrays;

import java.util.PriorityQueue;

/**
 * @author xxy
 * @date 2019/7/18
 * @description
 * ��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
 *
 * ˼·�����Ż��߿���
 * �������ȶ���  ����ֱ��ʹ��PriorityQueue���ȶ���ʵ�ֶ�
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
