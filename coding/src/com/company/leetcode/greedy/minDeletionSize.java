package com.company.leetcode.greedy;

/**
 * @author xxy
 * @date 2019/7/28
 * @description
 * 给定由N个小写字母字符串组成的数组，每个字符串长度相等。
 * 选取一个删除索引序列，对于A中的每个字符串，删除对应每个索引处的字符。
 * 所余下的字符串行从上往下读形成列。
 * 选择了一组删除索引 D，在执行删除操作之后，A 中剩余的每一列都是非降序排列的。
 * 返回 D.length 的最小可能值。
 */
public class minDeletionSize {
    public int minDeletionSize(String[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int r = A.length;
        int c = A[0].length();
        int count = 0;
        for(int i = 0;i<c;i++){
            for(int j = 0;j<r-1;j++){
                if(A[j].charAt(i)>A[j+1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
