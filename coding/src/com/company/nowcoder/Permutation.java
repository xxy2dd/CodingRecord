package com.company.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 */
public class Permutation {
    ArrayList<String> res= new ArrayList<String>();
    boolean f = true;
    public ArrayList<String> Permutation(String str) {
        if(str==null||str.length()==0){
            return res;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        while(f){
            nextPermutation(chars);
        }
        return res;
    }
    public void nextPermutation(char[] chars) {
        StringBuffer str = new StringBuffer();
        for(int i = 0;i<chars.length;i++){
            str.append(chars[i]);
        }
        res.add(str.toString());
        int i =chars.length-2;
        while(i>=0&&chars[i]>=chars[i+1]){
            i--;
        }
        if(i<0){
            f = false;
        }else{
            int j = chars.length-1;
            while(j>i&&chars[j]<=chars[i]){
                j--;
            }
            swap(chars,i,j);
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
}
