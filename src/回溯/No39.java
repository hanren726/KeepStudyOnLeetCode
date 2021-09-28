package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 */

public class No39 {

    public static void main(String[] args) {
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, 0, target, 0);
        return res;
    }

    List<Integer> temp = new ArrayList<>();

    public void backtracking(int[] candidates, int curSum, int target, int start) {
        if (curSum > target) {
            return;
        }
        if (curSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            curSum += candidates[i];
            backtracking(candidates, curSum, target, i);
            curSum -= candidates[i];
            temp.remove(temp.size() - 1);
        }
    }

}
