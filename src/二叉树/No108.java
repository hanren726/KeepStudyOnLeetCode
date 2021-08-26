package 二叉树;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class No108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int mid = nums.length / 2;
        int leftSize = mid;
        TreeNode root = new TreeNode(nums[mid]);
        int[] leftNums = new int[leftSize];
        int[] rightNums = new int[nums.length - leftSize - 1];
        for (int i = 0; i < leftSize; i++) {
            leftNums[i] = nums[i];
        }
        for (int i = 0; i < nums.length - leftSize - 1; i++) {
            rightNums[i] = nums[leftSize + i + 1];
        }
        root.left = sortedArrayToBST(leftNums);
        root.right = sortedArrayToBST(rightNums);
        return root;
    }
}
