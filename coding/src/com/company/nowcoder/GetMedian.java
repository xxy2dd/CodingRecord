package com.company.nowcoder;

import java.util.PriorityQueue;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ��εõ�һ���������е���λ����
 * ������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 * ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * ����ʹ��Insert()������ȡ��������
 * ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
 */
public class GetMedian {
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2)->o2-o1);
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    private int N = 0;
    public void Insert(Integer num) {
        if(N%2==0){
            left.add(num);
            right.add(left.poll());
        }else{
            right.add(num);
            left.add(right.poll());
        }
        N++;

    }

    public Double GetMedian() {
        if(N%2==0){
            return (left.peek()+right.peek())/2.0;
        }else{
            return (double)right.peek();
        }
    }

}
