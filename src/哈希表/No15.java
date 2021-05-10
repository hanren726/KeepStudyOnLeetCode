package 哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 15题
 *
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 */
public class No15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        No15 no15 = new No15();
        List<List<Integer>> res = no15.threeSum(nums);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> ans = res.get(i);
            for (int i1 = 0; i1 < ans.size(); i1++) {
                System.out.print(ans.get(i1) + "     ");
            }
            System.out.println("\n");
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int right = size - 1;
            int target = -nums[i];
            for (int left = i + 1; left < size; left++) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    continue;
                }
                while (left < right && nums[left] + nums[right] > target) {
                    right--;
                }
                if (left == right) {
                    break;
                }
                if (nums[left] + nums[right] == target) {
                    List<Integer> answer = new ArrayList<>();
                    answer.add(nums[left]);
                    answer.add(nums[right]);
                    answer.add(-target);
                    res.add(answer);
                }
            }
        }
        return res;
    }
}
