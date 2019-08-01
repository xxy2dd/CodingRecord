package com.company.leetcode.arrays;

import java.util.Stack;

/**
 * @author xxy
 * @date 2019/7/26
 * @description
 * ����ÿ�� ���� �б�����������һ���б���Ӧλ�õ�����������Ҫ�ٵȴ�����¶ȲŻ����߳������յ�������
 * ���֮�󶼲������ߣ����ڸ�λ����0 �����档
 * ���磬����һ���б�temperatures = [73, 74, 75, 71, 69, 72, 76, 73]��������Ӧ����[1, 1, 4, 2, 1, 1, 0, 0]��
 * ��ʾ������ �б��ȵķ�Χ��[1, 30000]��ÿ�����µ�ֵ�ľ�Ϊ���϶ȣ�������[30, 100]��Χ�ڵ�������
 */
public class dailyTemperatures {
    public static  void  main(String[] args){
        dailyTemperatures d = new dailyTemperatures();
        int[] temperatures ={73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = d.dailyTemperatures(temperatures);
        for(int i:res){
            System.out.println(i+" ");
        }

    }
    public int[] dailyTemperatures(int[] T) {
        if(T==null||T.length==0){
            return null;
        }
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<len;i++){
            while(!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int idx = stack.pop();
                res[idx] = i-idx;
            }
            stack.push(i);
        }
        return res;

    }
}
