package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1!=null && root2!=null){
            if(root1.val == root2.val){
                result = isSubTree(root1,root2);
            }
            if(!result){
                result = HasSubtree(root1.left,root2);
                if(!result){
                    result = HasSubtree(root1.right,root2);
                }
            }
        }
        return result;
    }
    private boolean isSubTree(TreeNode root1,TreeNode root2){
        if(root2==null){ return true; }
        if(root1==null&&root2!=null){ return false; }
        if(root1.val == root2.val){
            return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
        }else{
            return false;
        }
    }
}
