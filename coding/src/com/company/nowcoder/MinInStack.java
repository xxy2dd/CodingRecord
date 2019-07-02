package com.company.nowcoder;

import java.util.ArrayList;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class MinInStack {
    private int min = Integer.MAX_VALUE;
    private ArrayList<Integer> dataList = new ArrayList<>();
    private ArrayList<Integer> minList = new ArrayList<>();
    public void push(int node) {
        dataList.add(node);
        if(node<min){
            minList.add(node);
            min = node;
        }else{
            minList.add(min);
        }
    }
    public int getSize(){
        return dataList.size();
    }
    public void pop() {
        int end = getSize()-1;
        dataList.remove(end);
        minList.remove(end);
        min = minList.get(getSize()-1);
    }

    public int top() {
        return dataList.get(getSize()-1);
    }

    public int min() {
        return min;
    }
}
