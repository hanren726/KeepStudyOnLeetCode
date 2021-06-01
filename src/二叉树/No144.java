package 二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */


/**
 * 1. 确定递归函数的参数和返回值
 * 2. 确定终止条件
 * 3. 确定单层递归的逻辑
 */
public class No144 {

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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(res, root);
        return res;
    }

    public void preOrder(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preOrder(res, node.left);
        preOrder(res, node.right);
    }

    /**
     * 迭代方式前序遍历二叉树
     * @param root
     * @return
     */
    public List<Integer> preOrderDieDai(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }


}
