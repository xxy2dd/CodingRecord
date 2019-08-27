package com.company.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xxy
 * @date 2019/8/27
 * @description
 * 假设有打乱顺序的一群人站成一个队列。
 * 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。

注意：
总人数少于1100人。

示例

输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 */
public class reconstructQueue {
    public static void main(String[] args){
        int[][] people = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] res = reconstructQueue(people);
        for(int i =0;i<res.length;i++){
            for(int j = 0;j<res[0].length;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] reconstructQueue(int[][] people){
        if(people==null||people.length==0 || people[0].length==0){
            return new int[0][0];
        }
        // 按照 身高降序 k升序 排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
//        for(int i=0;i<people.length;i++){
//            list.add(people[i]);
//        }
        for(int[] p:people){
           list.add(p[1],p);
        }
//        int[] temp = new int[2];
        // k 定义为 排在 h 前面且身高大于等于h的人数
        // 因为从身高降序开始插入，此时所有人身高都大于等于h
        // 因此 k 即为需要插入的位置
//        for(int i=0;i<list.size();i++){
//            temp = list.get(i);
//            list.remove(i);
//            list.add(temp[1],temp);
//        }
        return list.toArray(new int[list.size()][]);
    }
}
