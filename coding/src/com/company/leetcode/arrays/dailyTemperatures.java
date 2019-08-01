package com.company.leetcode.arrays;

import java.util.Stack;

/**
 * @author xxy
 * @date 2019/7/26
 * @description
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。
 * 如果之后都不会升高，请在该位置用0 来代替。
 * 例如，给定一个列表temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是[1, 30000]。每个气温的值的均为华氏度，都是在[30, 100]范围内的整数。
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
