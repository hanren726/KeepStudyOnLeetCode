package 数组;

//leetcode 209: 给定一个含有n个正整数的数组和一个正整数 target 。
//找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
//
public class No209 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(getMin(arr, 7));
    }

    public static int getMin(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        int start = 0;
        int end = 0;
        if (n == 0) {
            return 0;
        }
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
