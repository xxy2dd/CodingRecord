package com.company.leetcode;

import java.util.PriorityQueue;

/**
 * @author xxy
 * @date 2019/7/3
 * @description
 * ����һ������ nums����һ����СΪ?k?�Ļ������ڴ������������ƶ�����������Ҳࡣ
 * ��ֻ���Կ����ڻ������� k �ڵ����֡���������ÿ��ֻ�����ƶ�һλ��
 * ���ػ����������ֵ��
 */
public class maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res= new int[nums.length-k+1];
        if(nums==null||nums.length<=1){
            return nums;
        }
        // �������ȶ��У��󶥶�
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2)->o2-o1);
        for(int i=0;i<k;i++){
            queue.add(nums[i]);
        }
        // ȡ����ǰ����������Ԫ�أ�����ɾ��
        res[0] = queue.peek();
        for(int i =0,j=i+k;j<nums.length;i++,j++){
            // �ƶ����ڣ�ɾ�������Ԫ��
            queue.remove(nums[i]);
            queue.add(nums[j]);
            res[i+1] = queue.peek();
        }
        return res;
    }
}
