package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {
    private long cnt = 0;
    private int[] temp;
    public int InversePairs(int [] array) {
        temp = new int[array.length];
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
