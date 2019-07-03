package com.company.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *  > 首先理解一下字典序算法
> 1. 从右往左，找出第一个左边小于右边的数，记为list[a]
> 2. 从右往左，找出第一个大于list[a]的数，设为list[b]
> 3. 交换list[a]，list[b]
> 4. 将list[a]后面的数据，由小到大排列即逆置
 */
public class Permutation {
    ArrayList<String> res1= new ArrayList<String>();
    boolean f = true;
    public ArrayList<String> Permutation(String str) {
        if(str==null||str.length()==0){
            return res1;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        while(f){
            nextPermutation(chars);
        }
        return res1;
    }
    public void nextPermutation(char[] chars) {
        StringBuffer str = new StringBuffer();
        for(int i = 0;i<chars.length;i++){
            str.append(chars[i]);
        }
        res1.add(str.toString());
        int i =chars.length-2;
        // 从右往左，找出第一个左边小于右边的数，
        while(i>=0&&chars[i]>=chars[i+1]){
            i--;
        }
        // 如果未找到，说明已经是最后一个排列，跳出循环
        if(i<0){
            f = false;
        }else{
        // 从右往左，找出第一个大于chars[i]的数
            int j = chars.length-1;
            while(j>i&&chars[j]<=chars[i]){
                j--;
            }
            // 交换
            swap(chars,i,j);
            // 将chars[i]后面的数据，由小到大排列即逆置,又因为本来chars[i]后面的数是从大到小排列的
            // 所以这里依次交换首尾两个数即可
            int k = chars.length-1;
            i++;
            for(;i<k;i++,k--){
                swap(chars,i,k);
            }

        }
    }
    public void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /* 方法二：依次交换后一个数和当前数
    *
    * */

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null||nums.length==0){
            return res;
        }
        permute(nums,0,nums.length-1);
        return res;
    }

    public void permute(int[] nums,int start,int end) {
        if(start==end){
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<nums.length;i++){
                list.add(nums[i]);
            }
            res.add(list);
        }else{
            for(int i = start;i<=end;i++){
                swap(nums,start,i);
                permute(nums,start+1,end);
                swap(nums,start,i);
            }
        }
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
