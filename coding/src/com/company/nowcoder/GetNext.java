package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
            return pNode;
        if (pNode.right != null) { // 节点有右子树
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else if ( pNode.next != null && pNode.next.left == pNode) { // 节点无右子树且该节点为父节点的左子节点
            return pNode.next;
        } else if (pNode.next != null && pNode.next .right == pNode) { // 节点无右子树且该节点为父节点的右子节点
            while(pNode.next != null && pNode .next .left != pNode){
                pNode = pNode.next ;
            }
            return pNode.next ;
        }else{
            return pNode.next ;//节点无父节点 ，即节点为根节点
        }

    }
}
