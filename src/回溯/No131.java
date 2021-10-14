package 回溯;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 */

/**
 * 拆字符串和组合问题非常非常类似，只是加了一些限制条件
 */

public class No131 {

    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();

    public List<List<String>> partition1(String s) {
        backtracking(s, 0);
        return ret;
    }

    public void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String temp = s.substring(startIndex,  i+1);
            if (isHuiWen(temp)) {
                ans.add(temp);
            } else {
                continue;
            }
            backtracking(s, i + 1);
            ans.remove(ans.size() - 1);
        }
    }

    public boolean isHuiWen(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
