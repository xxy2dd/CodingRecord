package com.company.sort;

/**
 * @author xxy
 * @date 2019/7/5
 * @description �鲢���򣺷���
 * �Ƚ�������ֳɼ���С���飬�ٶ�С��������Ȼ����Щ���������ϲ���һ�������������
 * ʱ�临�Ӷ� O(nlogn) �ȶ�
 */
public class mergeSort {
    public static void main(String[] args) {
        mergeSort m = new mergeSort();
        int[] nums = {10, 4, 5, 10, 8, 13, 12, 1, 7};
//        m.sort(nums);
        m.mergesort2(nums);
        for (int i : nums) {
            System.out.println(i + " ");
        }
    }

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        mergesort(nums, 0, nums.length - 1);
    }

    // ����˼· �ݹ�ʵ��

    public void mergesort(int[] nums, int left, int right) {
        // ע��ݹ�������� left>=right
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        // ����
        mergesort(nums, left, mid);
        mergesort(nums, mid + 1, right);
        // �ϲ�
        merge(nums, left, mid, right);

    }

    // �ǵݹ�ʵ��

    public void mergesort2(int[] nums){
        int n = nums.length,s = 2,i;
        while(s<=n){
            i=0;
            while(i+s<=n){
                merge(nums,i,i+s/2-1,i+s-1);
                // ÿ������s�����Ӹտ�ʼ������һ�鵽����һ�鵽�˰�һ��...
                i+=s;
            }
            int mid = i+s/2-1;
            if(mid>=n){
                mid = n-1;
            }
            // ����ĩβ���ಿ��
            merge(nums,i,mid,n-1);
            // һ�α������� s ��������
            s *= 2;
        }
        // ����ٴ�ͷ��β����һ��
        merge(nums,0,s/2-1,n-1);

    }

    public void merge(int[] nums, int left, int mid, int right) {

        // ��ʱ�����źϲ��͵Ľ��
        int[] temp = new int[nums.length];
        int k = 0;
        int i = left;
        int j = mid + 1;
        // ע��ѭ������
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // ���� δ��������
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int m = 0; m < k; m++) {
            nums[m + left] = temp[m];
        }
    }
}
