package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 思路：

我们先用两个指针分别指向两个子数组的末尾，并每次比较两个指针指向的数字。
如果第一个子数组中的数字大于第二个数组中的数字，则构成逆序对，并且逆序对的数目等于第二个子数组中剩余数字的个数，
如下图（a）和（c）所示。如果第一个数组的数字小于或等于第二个数组中的数字，则不构成逆序对，如图b所示。
每一次比较的时候，我们都把较大的数字从后面往前复制到一个辅助数组中，确保 辅助数组（记为copy） 中的数字是递增排序的。
在把较大的数字复制到辅助数组之后，把对应的指针向前移动一位，接下来进行下一轮比较。
 */
public class InversePairs {
    private long cnt = 0;
    private int[] temp;
    public int InversePairs(int [] array) {
        temp = new int[array.length];
        // 归并排序
        mergeSort(array,0,array.length-1);
        return (int)(cnt%1000000007);
    }
    private void mergeSort(int[] nums,int l,int h){
        if(h-l<1){
            return;
        }
        int m = l+(h-l)/2;
        mergeSort(nums,l,m);
        mergeSort(nums,m+1,h);
        merge(nums,l,m,h);
    }

    private void merge(int[] nums,int l,int m,int h){
        int i = l,j=m+1,k =l;
        while(i<=m||j<=h){
            if(i>m){
                temp[k] = nums[j++];
            }else if(j>h){
                temp[k] = nums[i++];
            }else if(nums[i]<nums[j]){
                temp[k] = nums[i++];
            }else{
                temp[k] = nums[j++];
                this.cnt += m-i+1;
            }
            k++;
        }
        for(k=l;k<=h;k++){
            nums[k] = temp[k];
        }
    }
}
