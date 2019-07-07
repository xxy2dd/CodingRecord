package com.company.traverse;

/**
 * @author xxy
 * @date 2019/7/7
 * @description
 */
public class postOrderRecursion {
    public void postOrderRecursion(TreeNode node){
        //如果结点为空则返回
        if(node==null) {
            return;
        }
        //访问左孩子
        postOrderRecursion(node.left);
        //访问右孩子
        postOrderRecursion(node.right);
        //访问根节点
        visit(node);
    }
    private void visit(TreeNode node){
        System.out.println(node.val+" ");
    }
}
