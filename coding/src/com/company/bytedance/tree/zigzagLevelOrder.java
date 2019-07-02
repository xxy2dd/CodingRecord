package com.company.bytedance.tree;




import java.util.LinkedList;
import java.util.List;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        printZhiOrder(res,root,0);
        return res;
    }
    private void printZhiOrder(List<List<Integer>> res,TreeNode node,int depth){
        if(node==null){
            return ;
        }
        if(res.size()<=depth){
            res.add(new LinkedList<>());
        }
        if(depth%2!=0){
            res.get(depth).add(0,node.val);
        }else{
            res.get(depth).add(node.val);
        }
        printZhiOrder(res,node.left,depth+1);
        printZhiOrder(res,node.right,depth+1);
    }
}
