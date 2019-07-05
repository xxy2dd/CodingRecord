package com.company.sort;

/**
 * @author xxy
 * @date 2019/7/5
 * @description
 * ������
 * �ѵ����ʣ�ÿ���ڵ��ֵ�����ڻ�������Һ��ӽڵ��ֵ���󶥶ѣ���ÿ���ڵ��ֵ��С�ڻ�������Һ��ӵ�ֵ��С���ѣ�
 */
public class heapSort {
    public static void main(String[] args){
        heapSort h = new heapSort();
        int[] nums = {10,11,2,8,4,5,3,0,56,44};
        h.heapsort(nums);
        for (int i : nums) {
            System.out.println(i + " ");
        }
    }
    public void heapsort(int[] nums){
        // ������������鹹����һ���󶥶�
        // �������е����ֵ���ǶѶ��Ľڵ㣬�����������β��Ԫ�ؽ�������ʱĪΪԪ�ؾ������ֵ
        // ʣ�µ�n-1�������ظ�����
        int n = nums.length;
        for(int i = n/2;i>=0;i--){
            heapAdjust(nums,i,n);
        }
        for(int i = n-1;i>0;i--){
            swap(nums,0,i);
            // ÿ�ν���֮��Ҫ��鵱ǰ���Ƿ���ϴ󶥶ѣ�������Ҫ���¹���
            heapAdjust(nums,0,i);
        }
    }
    public static void heapAdjust(int[] nums,int i,int n){
        int child,father;
        for(father=nums[i];(2*i+1)<n;i=child){
            child = 2*i+1;

            if(child!=n-1&&nums[child]<nums[child+1]){
                child++;
            }
            if(nums[child]>father){
                nums[i] = nums[child];
            }else{
                break;
            }
        }
        nums[i] = father;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
