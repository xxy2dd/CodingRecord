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
            // 如果两个元素的值相等，则判断是否是子树
            if(root1.val == root2.val){
                result = isSubTree(root1,root2);
            }
            // 不相等或不满足 则继续递归左子树和右子树
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
        // 对空值的判断
        if(root2==null){ return true; }
        if(root1==null&&root2!=null){ return false; }
        // 如果元素相等 则继续判断对应的左子树和右子树
        if(root1.val == root2.val){
            return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
        }else{
            return false;
        }
    }
}
