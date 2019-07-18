package com.company.leetcode.bitoperation;

/**
 * @author xxy
 * @date 2019/7/18
 * @description
 * ��������֮��ĺ�������ָ�������������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��
 * ������������ x �� y����������֮��ĺ������롣
 * ע�⣺
 * 0 �� x, y < 231.
 *
 * ˼·��
 * ��Ӧ������λ��ͬ��λ�õ���Ŀ ������ ������� �õ� ����ͬΪ1����ͬΪ0��
 * �����������ת��Ϊ �������1�ĸ���
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
