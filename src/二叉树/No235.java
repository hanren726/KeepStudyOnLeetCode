package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

public class No235 {

    //递归法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    //遍历法
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> p_path = getPath(root, p);
        List<TreeNode> q_path = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < p_path.size() && i < q_path.size(); ++i) {
            if (p_path.get(i) == q_path.get(i)) {
                ancestor = p_path.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (node.val > target.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }
}
