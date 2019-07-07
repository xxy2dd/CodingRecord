package com.company.leetcode.tree;

/**
 * @author xxy
 * @date 2019/7/7
 * @description
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
public class buildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||postorder==null){
            return null;
        }
        int inLength = inorder.length;
        int postLength = postorder.length;
        TreeNode root = buildTree(inorder,0,inLength-1,postorder,0,postLength-1);
        return root;

    }
    public TreeNode buildTree(int[] inorder,int startIn,int endIn, int[] postorder,int startPost,int endPost){
        if(startIn>endIn||startPost>endPost){
            return null;
        }
        TreeNode node = new TreeNode(postorder[endPost]);
        for(int i = startIn;i<=endIn;i++){
            if(inorder[i]==postorder[endPost]){
                node.left= buildTree(inorder,startIn,i-1,postorder,startPost,endPost-endIn+i-1);
                node.right = buildTree(inorder,i+1,endIn,postorder,endPost-endIn+i,endPost-1);
            }
        }
        return node;
    }
}
