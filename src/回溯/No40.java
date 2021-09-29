package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。
 *
 */

public class No40 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int curSum, int start) {
        if (curSum > target) {
            return;
        }
        if (curSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length && curSum + candidates[i] <= target; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            curSum += candidates[i];
            temp.add(candidates[i]);
            backtracking(candidates, target, curSum, i + 1);
            curSum -= candidates[i];
            temp.remove(temp.size() - 1);
        }
    }
}
