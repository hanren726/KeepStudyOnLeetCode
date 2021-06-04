package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 *给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */

public class No94 {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inOrderTraversal(TreeNode head) {
        List<Integer> res = new ArrayList<>();
        if (head == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = head;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
