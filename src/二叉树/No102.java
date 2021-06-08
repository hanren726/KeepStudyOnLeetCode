package 二叉树;

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 *
 */

public class No102 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> stack = new LinkedList<>();
        Queue<TreeNode> stack2 = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            List<Integer> curRes = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.poll();
                curRes.add(node.val);
                if (node.left != null) {
                    stack2.offer(node.left);
                }
                if (node.right != null) {
                    stack2.offer(node.right);
                }
            }
            res.add(curRes);
            while (!stack2.isEmpty()) {
                stack.offer(stack2.poll());
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            List<Integer> curRes = new ArrayList<>();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode node = queue.poll();
                curRes.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(curRes);
        }
        return res;
    }
}
