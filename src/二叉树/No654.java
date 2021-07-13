package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 *
 */

public class No654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return helper(nums, 0, nums.length);
    }

    public int findMax(int[] nums, int left, int right) {
        int max = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }

        int rootIndex = findMax(nums, left, right);
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = helper(nums, left, rootIndex);
        root.right = helper(nums, rootIndex + 1, right);
        return root;
    }
}
