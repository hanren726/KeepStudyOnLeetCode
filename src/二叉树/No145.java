package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 *
 *
 */
public class No145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        postOrder(res, root);
        return res;
    }

    public void postOrder(List<Integer> res, TreeNode node) {
        if (node == null) return;
        postOrder(res, node.left);
        postOrder(res, node.right);
        res.add(node.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
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
}
