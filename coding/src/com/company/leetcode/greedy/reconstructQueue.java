package com.company.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xxy
 * @date 2019/8/27
 * @description
 * �����д���˳���һȺ��վ��һ�����С�
 * ÿ������һ��������(h, k)��ʾ������h������˵���ߣ�k�����������ǰ������ߴ��ڻ����h��������
 * ��дһ���㷨���ؽ�������С�

ע�⣺
����������1100�ˡ�

ʾ��

����:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

���:
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
        // ���� ��߽��� k���� ����
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
        // k ����Ϊ ���� h ǰ������ߴ��ڵ���h������
        // ��Ϊ����߽���ʼ���룬��ʱ��������߶����ڵ���h
        // ��� k ��Ϊ��Ҫ�����λ��
//        for(int i=0;i<list.size();i++){
//            temp = list.get(i);
//            list.remove(i);
//            list.add(temp[1],temp);
//        }
        return list.toArray(new int[list.size()][]);
    }
}
