package com.company.traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author xxy
 * @date 2019/7/7
 * @description
 */
public class inOrderTraversal {
    /**
     * 先访问左子树，再回退到根节点，再访问根节点的右子树，这里的一个难点是从左子树回退到根节点的操作，
     * 虽然可以用栈来实现回退，但是要注意在出栈时保存根节点的引用，因为我们还需要通过根节点来访问右子树：
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null||!stack.isEmpty()){
            // 一直添加左节点 知道左节点为空
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            // 此时栈顶元素即为最左节点，取出
            curr = stack.pop();
            // 将节点值添加至结果中
            res.add(curr.val);
            // 添加该节点的右节点
            curr = curr.right;

        }
        return res;

    }

    /**
     * Mirros 算法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode rightmost = cur.left;
                while (rightmost.right != null) {
                    // 寻找左子树的最右节点
                    rightmost = rightmost.right;
                }
                // 当前节点作为左子树的最右节点的右孩子
                rightmost.right = cur;
                TreeNode oldRoot = cur;
                // 将左子树作为新的顶层节点
                cur = cur.left;
                // 消除左子树，防止出现无限循环
                oldRoot.left = null;
            }
        }
        return result;
    }
}
