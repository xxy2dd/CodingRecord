package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣
 * ���磬 ��5��3��7��2��4��6��8��    �У�
 * �������ֵ��С˳�����С����ֵΪ4��
 */
public class KthNode {
    TreeNode ret;
    int cnt = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        inOrder(pRoot,k);
        return ret;
    }
    private void inOrder(TreeNode root, int k){
        if(root==null||cnt>=k){
            return;
        }
        inOrder(root.left,k);
        cnt++;
        if(cnt==k){
            ret=root;
        }
        inOrder(root.right,k);
    }
}
