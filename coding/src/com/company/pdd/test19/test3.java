package com.company.pdd.test19;

import java.util.*;

/**
 * @author xxy
 * @date 2019/8/4
 * @description
 *
 * 现在一共有N个待执行的任务，每个任务需要Pi的时间完成执行。
 * 同时任务之间可能会有一些依赖关系，比如任务1可能依赖任务2和任务3，那么任务1必须等任务2和任务3执行完成后才能开始执行。
 * 为了最小化任务的平均返回时长，请安排所有任务的执行顺序。假设在零时刻，所有N个任务已到达系统。
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
        // 任务数量
        int n = sc.nextInt();
        // 任务依赖关系行数
        int m = sc.nextInt();
        Task[] t = new Task[n+1];
        for(int i = 1;i<n+1;i++){
            t[i] = new Task(i,sc.nextInt());
        }
        // 构建图
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n+1];
        for(int i=0;i<m;i++){
            // 出发点
            int u = sc.nextInt();
            // 目的点
            int v = sc.nextInt();
            if(graph.containsKey(u)){
                graph.get(u).add(v);
            }else{
                List<Integer> edges = new ArrayList<>();
                edges.add(v);
                graph.put(u,edges);
            }
            // 记录节点的入度
            indegree[v]++;
        }
        // 拓扑排序
        // 将放入队列的task 按照执行时间从小到大排列
        PriorityQueue<Task> queue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.weight-o2.weight;
            }
        });
        for(int i=1;i<n+1;++i){
            // 每次取出入度为0的任务放入队列
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
