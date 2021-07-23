package 二叉树;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 *
 * 解答：对于二叉搜索树，中序遍历后就是一个升序的数组，那么任意两个节点的差的绝对值最小一定出现在相邻的结点里
 *
 *
 * */


public class No530 {

    int pre;
    int ans;

    public int getMinDifference(TreeNode root) {
        pre = -1;
        ans = Integer.MAX_VALUE;
        dfs(root);

        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (pre == -1) {
            pre = node.val;
        } else {
            ans = Math.min(ans, node.val - pre);
            pre = node.val;
        }
        dfs(node.right);
    }
}
