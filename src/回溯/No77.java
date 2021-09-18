package 回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class No77 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> combine(int n, int k) {
        res.clear();
        path.clear();
        backtracking(1, n, k);
        return res;
    }

    public void backtracking(int startIndex, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.addLast(i);
            backtracking(i + 1, n, k);
            path.removeLast();
        }
    }

    //剪枝
    public void backtracking2(int startIndex, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            backtracking(i + 1, n, k);
            path.removeLast();
        }
    }
}
