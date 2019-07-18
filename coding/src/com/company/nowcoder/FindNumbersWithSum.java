package com.company.nowcoder;

import java.util.ArrayList;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S��
 * ����ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
*/
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(array==null||array.length<2){
            return result;
        }
        int i = 0,j=array.length-1;
        while(i<j){
            // ��Ϊ�����ǵ����� ���Ե�һ�����������ļ�Ϊ�˻���С��
            if(array[i]+array[j]==sum){
                result.add(array[i]);
                result.add(array[j]);
                return result;
            }else if(array[i]+array[j]>sum){
                j--;
            }else {
                i++;
            }
        }
        return result;
    }
}
