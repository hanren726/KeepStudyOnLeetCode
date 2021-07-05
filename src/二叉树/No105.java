package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */

public class No105 {

    int[] preorder = null;
    int[] inorder = null;
    Map<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        int index = 0;
        for(Integer order: inorder) {
            map.put(order, index++);
        }
        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int rootVal = preorder[preIndex];
        int inIndex = map.get(rootVal);
        preIndex++;
        TreeNode root = new TreeNode(rootVal);
        TreeNode leftNode = helper(left, inIndex -1);
        TreeNode rightNode = helper(inIndex+1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
