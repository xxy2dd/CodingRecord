package com.company.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xxy
 * @date 2019/7/25
 * @description
 * 现在你总共有 n 门课需要选，记为0到n-1。
 * 在选修某些课程之前需要一些先修课程。例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。你可以假定输入的先决条件中没有重复的边。
 * 提示:
 * 1.这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 2.通过 DFS 进行拓扑排序
 * 3.拓扑排序也可以通过BFS完成。
 *
 * 流程：
 * 1、在开始排序前，扫描对应的存储空间（使用邻接表），将入度为0的结点放入队列。
 * 2、只要队列非空，就从队首取出入度为 0的结点，将这个结点输出到结果集中，并且将这个结点的所有邻接结点（它指向的结点）的入度减1，在减 1以后，如果这个被减1的结点的入度为0 ，就继续入队。
 * 3、当队列为空的时候，检查结果集中的顶点个数是否和课程数相等即可。
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
        // 初始所有节点入度为0
        Arrays.fill(inDegree,0);
        // 计算节点入度
        for(int[] p :prerequisites){
            inDegree[p[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        // 加入入度为0的节点
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            // 取出队列中的头结点
            Integer num = queue.removeFirst();
            // 添加到结果集中
            res.add(num);
            // 遍历邻边,所有和num相邻的边的入度都减1
            for(int[] p:prerequisites){
                if(p[1]==num){
                    inDegree[p[0]]--;
                    // 同时判断减1之后该点的入度是否为0
                    if(inDegree[p[0]]==0){
                        queue.add(p[0]);
                    }
                }
            }
        }
        // 队列为空，检查结果集中的顶点个数是否和课程数相等即可。
        return res.size()==numCourses;
    }
}
