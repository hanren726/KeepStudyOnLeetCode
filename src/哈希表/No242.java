package 哈希表;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 */
public class No242 {

    public boolean isAnagram(String s, String t) {
        if (s == null) {
            return t == null;
        } else {
            if (t == null) {
                return false;
            } else {
                int[] arr = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    arr[s.charAt(i) - 'a']++;
                }
                for (int i = 0; i < t.length(); i++) {
                    int curChar = t.charAt(i) - 'a';
                    arr[curChar]--;
                    if (arr[curChar] < 0) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
