package com.company.leetcode.arrays;

import java.util.*;

/**
 * @author xxy
 * @date 2019/7/3
 * @description
 * 给定一个非空的整数数组，返回其中出现频率前?k?高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * 你可以假设给定的?k?总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) ,?n?是数组的大小。
 *
 * 思路：最大堆  哈希表
 */
public class topKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums==null || nums.length == 0){
            return res;
        }
        // 构件最大堆 重写compare方法 这里还有一个巧妙之处  使用了Map.Entry
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer,Integer>>(){
            @Override
            public int compare(Map.Entry<Integer,Integer> o1,Map.Entry<Integer,Integer> o2){
                return o2.getValue()-o1.getValue();
            }

        });
        // 遍历数组 用哈希表存储每个数出现字数
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
        // 放入堆
        for(Map.Entry<Integer,Integer> entry :map.entrySet()) {
            pq.add(entry);
        }
        // 取出前K个数
        for(int i =0;i<k;i++){
            res.add(pq.poll().getKey());
        }
        return res;
    }
}
