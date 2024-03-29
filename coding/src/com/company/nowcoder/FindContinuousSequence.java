package com.company.nowcoder;

import java.util.ArrayList;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int plow=1,phigh=2;
        // 滑动窗口的思想
        while(plow<phigh){
            // 求和公式
            int cur_sum = (plow+phigh)*(phigh-plow+1)/2;
            if(cur_sum==sum){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i = plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
            }else if(cur_sum>sum){
                // 结果比sum大，则移动low指针
                plow++;
            }else{
                // 结果小，则移动high指针
                phigh++;
            }
        }
        return result;
    }
}
