package com.company.nowcoder;

import java.util.ArrayList;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ����һ�Ŷ������ĸ��ڵ��һ��������
 * ��ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * (ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 */
public class Backtracking {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        backtracking(root,target,new ArrayList<Integer>());
        return result;
    }
    private void backtracking(TreeNode node,int target,ArrayList<Integer> path){
        if(node==null){
            return;
        }
        path.add(node.val);
        target -= node.val;
        if(target==0&&node.left==null&&node.right==null){
            result.add(new ArrayList<>(path));
        }else{
            backtracking(node.left,target,path);
            backtracking(node.right,target,path);
        }
        path.remove(path.size()-1);
    }
}
