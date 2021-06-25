package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 */
public class No404 {

    //广度优先
    class NodeWithDirection {
        TreeNode node;
        boolean isLeft;

        public NodeWithDirection(TreeNode node, boolean isLeft) {
            this.node = node;
            this.isLeft = isLeft;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<NodeWithDirection> queue = new LinkedList<>();
        queue.offer(new NodeWithDirection(root, false));
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NodeWithDirection node = queue.poll();
                if (node.node.left != null) {
                    NodeWithDirection leftNode = new NodeWithDirection(node.node.left, true);
                    queue.offer(leftNode);
                }
                if (node.node.right != null) {
                    NodeWithDirection rightNode = new NodeWithDirection(node.node.right, false);
                    queue.offer(rightNode);
                }
                if (node.node.left == null && node.node.right == null && node.isLeft) {
                    res += node.node.val;
                }
            }
        }
        return res;
    }

    //深度优先
    int res = 0;
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        doCalculate(root);
        return res;
    }

    public void doCalculate(TreeNode node) {
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                res += node.left.val;
            } else {
                doCalculate(node.left);
            }
        }
        if (node.right != null) {
            doCalculate(node.right);
        }
    }

}
