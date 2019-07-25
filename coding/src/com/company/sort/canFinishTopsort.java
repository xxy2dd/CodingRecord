package com.company.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xxy
 * @date 2019/7/25
 * @description
 * �������ܹ��� n �ſ���Ҫѡ����Ϊ0��n-1��
 * ��ѡ��ĳЩ�γ�֮ǰ��ҪһЩ���޿γ̡����磬��Ҫѧϰ�γ� 0 ������Ҫ����ɿγ� 1 ��������һ��ƥ������ʾ����: [0,1]
 * �����γ������Լ����ǵ��Ⱦ��������ж��Ƿ����������пγ̵�ѧϰ��
 * ������Ⱦ��������ɱ�Ե�б��ʾ��ͼ�Σ��������ڽӾ���������μ�ͼ�ı�ʾ��������Լٶ�������Ⱦ�������û���ظ��ıߡ�
 * ��ʾ:
 * 1.��������൱�ڲ���һ��ѭ���Ƿ����������ͼ�С��������ѭ�����򲻴�������������˲�����ѡȡ���пγ̽���ѧϰ��
 * 2.ͨ�� DFS ������������
 * 3.��������Ҳ����ͨ��BFS��ɡ�
 *
 * ���̣�
 * 1���ڿ�ʼ����ǰ��ɨ���Ӧ�Ĵ洢�ռ䣨ʹ���ڽӱ��������Ϊ0�Ľ�������С�
 * 2��ֻҪ���зǿգ��ʹӶ���ȡ�����Ϊ 0�Ľ�㣬�������������������У����ҽ�������������ڽӽ�㣨��ָ��Ľ�㣩����ȼ�1���ڼ� 1�Ժ�����������1�Ľ������Ϊ0 ���ͼ�����ӡ�
 * 3��������Ϊ�յ�ʱ�򣬼�������еĶ�������Ƿ�Ϳγ�����ȼ��ɡ�
 */
public class canFinishTopsort {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=0){
            return false;
        }
        int len = prerequisites.length;
        if(len==0){
            return true;
        }
        int[] inDegree = new int[numCourses];
        // ��ʼ���нڵ����Ϊ0
        Arrays.fill(inDegree,0);
        // ����ڵ����
        for(int[] p :prerequisites){
            inDegree[p[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        // �������Ϊ0�Ľڵ�
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            // ȡ�������е�ͷ���
            Integer num = queue.removeFirst();
            // ��ӵ��������
            res.add(num);
            // �����ڱ�,���к�num���ڵıߵ���ȶ���1
            for(int[] p:prerequisites){
                if(p[1]==num){
                    inDegree[p[0]]--;
                    // ͬʱ�жϼ�1֮��õ������Ƿ�Ϊ0
                    if(inDegree[p[0]]==0){
                        queue.add(p[0]);
                    }
                }
            }
        }
        // ����Ϊ�գ���������еĶ�������Ƿ�Ϳγ�����ȼ��ɡ�
        return res.size()==numCourses;
    }
}
