package com.company.pdd.test19;

import java.util.*;

/**
 * @author xxy
 * @date 2019/8/4
 * @description
 *
 * ����һ����N����ִ�е�����ÿ��������ҪPi��ʱ�����ִ�С�
 * ͬʱ����֮����ܻ���һЩ������ϵ����������1������������2������3����ô����1���������2������3ִ����ɺ���ܿ�ʼִ�С�
 * Ϊ����С�������ƽ������ʱ�����밲�����������ִ��˳�򡣼�������ʱ�̣�����N�������ѵ���ϵͳ��
 */
public class test3 {
    static class Task{
        int seq;
        int weight;
        public Task(int n,int w){
            this.seq = n;
            this.weight = w;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // ��������
        int n = sc.nextInt();
        // ����������ϵ����
        int m = sc.nextInt();
        Task[] t = new Task[n+1];
        for(int i = 1;i<n+1;i++){
            t[i] = new Task(i,sc.nextInt());
        }
        // ����ͼ
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n+1];
        for(int i=0;i<m;i++){
            // ������
            int u = sc.nextInt();
            // Ŀ�ĵ�
            int v = sc.nextInt();
            if(graph.containsKey(u)){
                graph.get(u).add(v);
            }else{
                List<Integer> edges = new ArrayList<>();
                edges.add(v);
                graph.put(u,edges);
            }
            // ��¼�ڵ�����
            indegree[v]++;
        }
        // ��������
        // ��������е�task ����ִ��ʱ���С��������
        PriorityQueue<Task> queue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.weight-o2.weight;
            }
        });
        for(int i=1;i<n+1;++i){
            // ÿ��ȡ�����Ϊ0������������
            if(indegree[i]==0){
                queue.offer(t[i]);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            Task complete = queue.poll();
            res.add(complete.seq);
            if(graph.containsKey(complete.seq)){
                for(int i:graph.get(complete.seq)){
                    if(--indegree[i]==0){
                        queue.offer(t[i]);
                    }
                }
            }
        }
        for(int i = 0;i<n;i++){
            System.out.print(res.get(i));
            if(i!=n-1){
                System.out.print(" ");
            }
        }
    }
}
