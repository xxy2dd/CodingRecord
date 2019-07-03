package com.company.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 *  > �������һ���ֵ����㷨
> 1. ���������ҳ���һ�����С���ұߵ�������Ϊlist[a]
> 2. ���������ҳ���һ������list[a]��������Ϊlist[b]
> 3. ����list[a]��list[b]
> 4. ��list[a]��������ݣ���С�������м�����
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
        // ���������ҳ���һ�����С���ұߵ�����
        while(i>=0&&chars[i]>=chars[i+1]){
            i--;
        }
        // ���δ�ҵ���˵���Ѿ������һ�����У�����ѭ��
        if(i<0){
            f = false;
        }else{
        // ���������ҳ���һ������chars[i]����
            int j = chars.length-1;
            while(j>i&&chars[j]<=chars[i]){
                j--;
            }
            // ����
            swap(chars,i,j);
            // ��chars[i]��������ݣ���С�������м�����,����Ϊ����chars[i]��������ǴӴ�С���е�
            // �����������ν�����β����������
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

    /* �����������ν�����һ�����͵�ǰ��
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
