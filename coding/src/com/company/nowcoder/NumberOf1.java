package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ����һ��������������������Ʊ�ʾ��1�ĸ�����
 * ���и����ò����ʾ��
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        int count = 0;
        while(n!=0){
            count++;
            n = n&(n-1);
        }
        return count;

    }
}
