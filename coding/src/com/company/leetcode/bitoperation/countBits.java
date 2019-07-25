package com.company.leetcode.bitoperation;

/**
 * @author xxy
 * @date 2019/7/25
 * @description
 * ����һ���Ǹ����� num������ 0 �� i �� num ��Χ�е�ÿ������ i ����������������е� 1 ����Ŀ����������Ϊ���鷵�ء�
 * ����ʱ�临�Ӷ�ΪO(n*sizeof(integer))�Ľ��ǳ����ס�
 * �������������ʱ��O(n)����һ��ɨ��������
 * Ҫ���㷨�Ŀռ临�Ӷ�ΪO(n)��
 * �ҵ�˼·������ 1�ĸ��� �����˼·����һ��forѭ������������ʱ�临�ӶȻ�ܸ�
 *
 */
public class countBits {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i=1;i<=num;i++){
            // i&(i-1) ȥ�����ұߵ�1���������Ҫ����1
            res[i] = res[i&(i-1)]+1;
        }
        return res;
    }
    public int[] countBits2(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i=1;i<=num;i++){
            // i/2=i>>2   i%2=i&1
            // i>>1 ��ʾ����һλ��i&1 ��ʾ���һλ�Ƿ�Ϊ1
            res[i] = res[i>>1]+(i&1);
        }
        return res;
    }

    public int[] countBits3(int num){
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i=1;i<=num;i++){
           if(i%2==1){
               // ������ǰ���ż����һ��1
               res[i] = res[i-1]+1;
           }else{
               // ż����1�ĸ����ͳ���2֮����Ǹ���һ���࣬��Ϊ���λ��0
               // ����2 �൱������һλ��Ĩ�������λ��0
               res[i] = res[i>>1];
           }
        }
        return res;
    }
}
