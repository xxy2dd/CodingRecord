package com.company.nowcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input.length<k||input==null||k<=0){
            return res;
        }
        Queue<Integer> queue = new PriorityQueue<>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i = 0;i<input.length;i++){
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
