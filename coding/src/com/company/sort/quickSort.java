package com.company.sort;

/**
 * @author xxy
 * @date 2019/7/4
 * @description
 * 快排 ： 将一组数以一个基准分为两部分 左边小于基准 右边大于基准
 * 然后再将左边的看做一个数组 继续进行这个过程 右边的同理
 * 时间复杂度 O(nlogn) ，最坏是O(n^2)，不稳定
 */
public class quickSort {
    public static void main(String[] args){
        quickSort q = new quickSort();
        int[] nums = {10,4,5,10,8,13,12,1,7};
        q.sort(nums);
        for(int i:nums){
            System.out.println(i +" ");
        }
    }
    public void sort(int[] nums){
        if(nums==null||nums.length==0){
            return;
        }
        int len = nums.length;
        // 为了可以递归调用快排函数，所以这里要传三个参数，一个数组本身，一个左指针下标，一个右指针下标
        quicksort(nums,0,len-1);
    }
    public void quicksort(int[] nums,int left,int right){
        // 递归终止条件  left>=right
        if(left>=right){
            return;
        }
        // 得到基准的位置 此时 基准的左边都小于基准，基准的右边都大于基准
        // 所以只需再对基准的左边和右边分别重复快排过程即可
        int m = partition2(nums,left,right);
        quicksort(nums,left,m-1);
        quicksort(nums,m+1,right);
    }
    public int partition(int[] nums,int left,int right){
        // 以left所指向的数为基准
        int i = left;
        // 循环终止条件 left<right
        while(left<right){
            // 注意 不要在内部循环忘记left<right这个条件！
            // 如果right指向的数大于基准，right--即右移
            while(left<right&&nums[right]>=nums[i]){
                right--;
            }
            // 如果left指向的数小于基准，left++即左移
            while(left<right&&nums[left]<=nums[i]){
               left++;
            }
            if(left<right){
                // 当不满足上述两个条件时即当前右指针指向的数小于基准，左指针指向的数大于基准 ，交换这两个数
                swap(nums,left,right);
            }

        }
        // 不满足循环条件时，left==right 最后交换left和i的位置，将基准数换到它对应的位置，此时基准数左边都小于它，右边都大于它
        swap(nums,left,i);
        return left;
    }
    public void swap(int[] nums,int left,int right){
       int temp = nums[left];
       nums[left] = nums[right];
       nums[right] = temp;
    }

    public int partition2(int[] nums,int left,int right){
        // 以left所指向的数为基准
        int mid = nums[left];
        // 循环终止条件 left<right
        while(left<right){
            // 如果right指向的数大于基准，right--即右移
            while(left<right&&nums[right]>mid){
                right--;
            }
            // 注意 不要忘记left<right这个条件！
            if(left<right){
                nums[left++] = nums[right];
            }
            // 如果left指向的数小于基准，left++即左移
            while(left<right&&nums[left]<mid){
                left++;
            }
            // 注意 不要忘记left<right这个条件！
            if(left<right){
                nums[right--] = nums[left];
            }

        }
        // 不满足循环条件时，left==right 最后将基准数填到它对应的位置，此时基准数左边都小于它，右边都大于它
        nums[left] = mid;
        return left;
    }
}
