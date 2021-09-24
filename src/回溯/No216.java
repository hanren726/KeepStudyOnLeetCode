package 回溯;

import java.util.*;

/**
 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

 说明：

 所有数字都是正整数。
 解集不能包含重复的组合。
 示例 1:
 输入: k = 3, n = 7
 输出: [[1,2,4]]

 示例 2:
 输入: k = 3, n = 9
 输出: [[1,2,6], [1,3,5], [2,3,4]]

 */

public class No216 {

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 0, 1);
        return res;
    }

    public void backtracking(int k, int n, int sum, int start) {
        if (temp.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<Integer>(temp));
                return;
            }
        }
        for (int i = start; i <= 9; i++) {
            sum += i;
            temp.add(i);
            backtracking(k, n, sum, i + 1);
            temp.remove(temp.size() - 1);
            sum -= i;
        }
    }

    public void backtracking2(int k, int n, int start) {
        if (temp.size() == k) {
            int tempSum = 0;
            for (Integer a : temp) {
                tempSum += a;
            }
            if (tempSum == n) {
                res.add(new ArrayList<Integer>(temp));
                return;
            }
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            backtracking2(k, n, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
