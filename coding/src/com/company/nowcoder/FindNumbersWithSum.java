package com.company.nowcoder;

import java.util.ArrayList;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
*/
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(array==null||array.length<2){
            return result;
        }
        int i = 0,j=array.length-1;
        while(i<j){
            // 因为数组是递增的 所以第一次满足条件的即为乘积最小的
            if(array[i]+array[j]==sum){
                result.add(array[i]);
                result.add(array[j]);
                return result;
            }else if(array[i]+array[j]>sum){
                j--;
            }else {
                i++;
            }
        }
        return result;
    }
}
