package com.company.leetcode.arrays;

/**
 * @author xxy
 * @date 2019/7/8
 * @description
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组[0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2])。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
 * 你可以假设数组中不存在重复的元素。你的算法时间复杂度必须是O(logn) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 思路：因为复杂度要O(logn) ，所以采用二分查找，但因为本题数据的特殊性，所以要特别处理，
 */
public class search {
    public static void main(String[] args){
        search s = new search();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int res = s.search(nums,target);
        System.out.println(res);

    }
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid] == target){
                return mid;
            }
            // nums[mid] < nums[high]说明mid在第二个递增序列
            if (nums[mid] < nums[high]){
                // 如果nums[mid] < target && nums[high]>=target说明target 在mid和high之间（如果存在）
                if (nums[mid] < target && nums[high]>=target){
                    low = mid + 1;
                }else{ // 否则说明target 在前一个递增序列中（如果存在）
                    high = mid - 1;
                }
            }else{ // 说明mid在第一个递增序列中
                // target在第一个递增序列中（如果存在）
                if (nums[mid] > target && nums[low] <= target){
                    high = mid - 1;
                }else {// target在第二个递增序列中（如果存在）
                    low = mid + 1;
                }
            }
        }
        // 找不到 返回 -1
        return -1;

    }
}
