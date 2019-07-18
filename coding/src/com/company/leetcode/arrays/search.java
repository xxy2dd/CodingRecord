package com.company.leetcode.arrays;

/**
 * @author xxy
 * @date 2019/7/8
 * @description
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��( ���磬����[0,1,2,4,5,6,7]���ܱ�Ϊ[4,5,6,7,0,1,2])��
 * ����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻�-1��
 * ����Լ��������в������ظ���Ԫ�ء�����㷨ʱ�临�Ӷȱ�����O(logn) ����
 * ʾ�� 1:
 * ����: nums = [4,5,6,7,0,1,2], target = 0
 * ���: 4
 *
 * ˼·����Ϊ���Ӷ�ҪO(logn) �����Բ��ö��ֲ��ң�����Ϊ�������ݵ������ԣ�����Ҫ�ر���
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
            // nums[mid] < nums[high]˵��mid�ڵڶ�����������
            if (nums[mid] < nums[high]){
                // ���nums[mid] < target && nums[high]>=target˵��target ��mid��high֮�䣨������ڣ�
                if (nums[mid] < target && nums[high]>=target){
                    low = mid + 1;
                }else{ // ����˵��target ��ǰһ�����������У�������ڣ�
                    high = mid - 1;
                }
            }else{ // ˵��mid�ڵ�һ������������
                // target�ڵ�һ�����������У�������ڣ�
                if (nums[mid] > target && nums[low] <= target){
                    high = mid - 1;
                }else {// target�ڵڶ������������У�������ڣ�
                    low = mid + 1;
                }
            }
        }
        // �Ҳ��� ���� -1
        return -1;

    }
}
