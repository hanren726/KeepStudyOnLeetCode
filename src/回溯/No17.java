package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 看图 img.png
 */

public class No17 {

    public String[] letterMap = new String[]{
            "", //0
            "", //1
            "abc", //2
            "def", //3
            "ghi", //4
            "jkl", //5
            "mno", //6
            "pqrs", //7
            "tuv", //8
            "wxyz"//9
    };

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        backtracking(digits, new StringBuffer(), 0);
        return res;
    }

    public void backtracking(String digits, StringBuffer sb, int index) {
        if (digits.length() == index) {
            res.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = letterMap[digit];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtracking(digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
