package com.company.nowcoder;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 * ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
 * ��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
 * {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 */
public class MaxInWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(size==0||size>num.length||num==null){
            return res;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2)->o2-o1);
        for(int i = 0;i<size;i++){
            heap.add(num[i]);
        }
        res.add(heap.peek());
        for(int i=0,j=i+size;j<num.length;i++,j++){
            heap.remove(num[i]);
            heap.add(num[j]);
            res.add(heap.peek());
        }

        return res;
    }
}
