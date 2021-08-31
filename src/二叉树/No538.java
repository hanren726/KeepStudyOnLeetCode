package 二叉树;

import java.util.Stack;

/**
 *给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *

 */

public class No538 {

    //递归法
    int pre;

    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }

    public void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        traversal(node.right);
        node.val += node.val + pre;
        pre = node.val;
        traversal(node.left);
    }

    //迭代法
    public TreeNode convertBST1(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }

    public void traversal1(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.right;
            } else {
                cur = stack.pop();
                cur.val += pre;
                pre = cur.val;
                cur = cur.left;
            }
        }
    }
}
