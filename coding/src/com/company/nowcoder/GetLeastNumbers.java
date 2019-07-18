package com.company.nowcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input.length<k||input==null||k<=0){
            return res;
        }
        // 优先队列  最大堆
        Queue<Integer> queue = new PriorityQueue<>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i = 0;i<input.length;i++){
            // 先初始化 构建k个数的最大堆
            if(queue.size()<k){
                queue.add(input[i]);
            }else{

                if(input[i]<queue.peek()){
                    queue.remove(queue.peek());
                    queue.add(input[i]);
                }
            }
        }
        while(!queue.isEmpty()){
            res.add(queue.remove());
        }
        return res;
    }
}
