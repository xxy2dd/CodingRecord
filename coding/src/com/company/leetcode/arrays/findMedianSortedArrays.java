package com.company.leetcode.arrays;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 遍历两个数组 合并
 */
public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int lengthall = length1 + length2;
        int[] all = new int[length1 + length2];
        int i = 0, j = 0, k = 0;
        while(i<length1&&j<length2){
            if(nums1[i]<nums2[j]){
                all[k++] = nums1[i++];
            }else{
                all[k++] = nums2[j++];
            }
        }
        while(i<length1){
            all[k++] = nums1[i++];
        }
        while(j<length2){
            all[k++] = nums2[j++];
        }
        double result;
        if (lengthall % 2 == 0) {
            result = (all[lengthall / 2 - 1] + all[lengthall / 2]) / 2.0;
        } else {
            result = all[lengthall / 2];
        }
        return result;
    }
}
