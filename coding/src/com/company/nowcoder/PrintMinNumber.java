package com.company.nowcoder;

import java.util.ArrayList;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if(numbers==null||numbers.length==0){
            return "";
        }
        StringBuilder res = new StringBuilder();
        int n = numbers.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i<n;i++){
            list.add(numbers[i]);
        }
        list.sort((str1,str2)->{
            String s1 = str1 + "" + str2;
            String s2 = str2 + "" + str1;
            return s1.compareTo(s2);
        });
        for(int i:list){
            res.append(i);
        }
        return res.toString();

    }
}
