package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class No106 {

    int[] postOrder;
    int[] inorder;
    int postIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();
    

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postOrder = postorder;
        postIndex = postOrder.length - 1;
        int index = 0;
        for (int order : inorder) {
            map.put(order, index++);
        }
        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int root_val = postOrder[postIndex];        //拿到根结点的值
        TreeNode root = new TreeNode(root_val);     //构造根结点

        int index = map.get(root_val);              //根结点在中序遍历里的index

        postIndex--;                                //继续看前一个值，这是右子树的根结点

        root.right = helper(index + 1, right);  //构造右子树
        root.left = helper(left, index - 1);   //构造左子树
        return root;

    }


}
