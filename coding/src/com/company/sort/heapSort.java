package com.company.sort;

/**
 * @author xxy
 * @date 2019/7/5
 * @description
 * 堆排序
 * 堆的性质：每个节点的值都大于或等于左右孩子节点的值（大顶堆）；每个节点的值都小于或等于左右孩子的值（小顶堆）
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
        // 将待排序的数组构建成一个大顶堆
        // 整个序列的最大值就是堆顶的节点，将它与数组的尾部元素交换，此时莫为元素就是最大值
        // 剩下的n-1个序列重复构造
        int n = nums.length;
        for(int i = n/2;i>=0;i--){
            heapAdjust(nums,i,n);
        }
        for(int i = n-1;i>0;i--){
            swap(nums,0,i);
            // 每次交换之后都要检查当前堆是否符合大顶堆，不符合要重新构造
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
