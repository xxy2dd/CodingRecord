package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 统计一个数字在排序数组中出现的次数
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int first = binarySearch(array,k);
        int last = binarySearch(array,k+1);
        return (first==array.length||array[first]!=k)?0:last-first;
    }
    // 二分查找找最左侧元素模板
    private int binarySearch(int [] array , int k){
        int l = 0 , h =array.length;
        while(l<h){
            int m = l+(h-l)/2;
            if(array[m]>=k){
                h=m;
            }else{
                l=m+1;
            }
        }
        return l;
    }
}
