package com.company.pdd.test19;

import java.util.*;

/**
 * @author xxy
 * @date 2019/7/28
 * @description
 * ����һ���ַ������飨�ַ������Ⱥ����鳤�Ⱦ�����1��С��1024���������ַ���Ϊ��д��ĸ��
 * ���ʣ��������ַ��������Ƿ���ͨ������������Ԫ�ص�˳�򣬴Ӷ���β�������γ�һ������
 */
public class test2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[] a = scan.nextLine().split(" ");
        List<Character> head = new ArrayList<Character>();
        List<Character> tail = new ArrayList<Character>();
        for(int i = 0;i<a.length;i++){
            head.add(a[i].charAt(0));
            tail.add(a[i].charAt(a[i].length()-1));
        }
        Collections.sort(head);
        Collections.sort(tail);
        for(int i =0;i<head.size();i++){
            if(!head.get(i).equals(tail.get(i))){
                System.out.println("false");
            }
        }
        System.out.println("true");

    }
}
