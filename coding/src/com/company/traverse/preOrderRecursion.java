package com.company.traverse;


/**
 * @author xxy
 * @date 2019/7/7
 * @description
 */
public class preOrderRecursion {
    public void preOrderRecursion(TreeNode node){
        //如果结点为空则返回
        if(node==null) {
            return;
        }
        //访问根节点
        visit(node);
        //访问左孩子
        preOrderRecursion(node.left);
        //访问右孩子
        preOrderRecursion(node.right);
    }

    private void visit(TreeNode node){
        System.out.println(node.val+" ");
    }


}
