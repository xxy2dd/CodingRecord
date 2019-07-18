package com.company.leetcode.arrays;

import java.util.*;

/**
 * @author xxy
 * @date 2019/7/3
 * @description
 * ����һ���ǿյ��������飬�������г���Ƶ��ǰ?k?�ߵ�Ԫ�ء�
 * ʾ�� 1:
 * ����: nums = [1,1,1,2,2,3], k = 2
 * ���: [1,2]
 * ʾ�� 2:
 * ����: nums = [1], k = 1
 * ���: [1]
 * ˵����
 * ����Լ��������?k?���Ǻ���ģ��� 1 �� k �� �����в���ͬ��Ԫ�صĸ�����
 * ����㷨��ʱ�临�Ӷȱ������� O(n log n) ,?n?������Ĵ�С��
 *
 * ˼·������  ��ϣ��
 */
public class topKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums==null || nums.length == 0){
            return res;
        }
        // �������� ��дcompare���� ���ﻹ��һ������֮��  ʹ����Map.Entry
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer,Integer>>(){
            @Override
            public int compare(Map.Entry<Integer,Integer> o1,Map.Entry<Integer,Integer> o2){
                return o2.getValue()-o1.getValue();
            }

        });
        // �������� �ù�ϣ��洢ÿ������������
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int key = nums[i];
            if(map.containsKey(key)){
                int v = map.get(nums[i]);
                map.put(key,v+1);
            }else{
                map.put(key,1);
            }
        }
        // �����
        for(Map.Entry<Integer,Integer> entry :map.entrySet()) {
            pq.add(entry);
        }
        // ȡ��ǰK����
        for(int i =0;i<k;i++){
            res.add(pq.poll().getKey());
        }
        return res;
    }
}
