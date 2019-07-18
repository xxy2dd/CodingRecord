package com.company.leetcode.bitoperation;

/**
 * @author xxy
 * @date 2019/7/18
 * @description
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 思路：
 * 对应二进制位不同的位置的数目 可以用 异或运算 得到 （不同为1，相同为0）
 * 接下来问题就转换为 异或结果中1的个数
 */
public class hammingDistance {
    public int hammingDistance(int x, int y) {
        int temp = x^y;
        int count = 0;
        while(temp!=0){
            temp = temp&(temp-1);
            count++;
        }
        return count;
    }
    public int hammingDistance2(int x, int y) {
        int res = x^y;
        int dis = 0;
        while(res>0){

            if((res & 1)==1){
                dis +=1;
            }
            res>>=1;
        }
        return dis;
    }
}
