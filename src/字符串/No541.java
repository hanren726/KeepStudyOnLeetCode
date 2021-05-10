package 字符串;

/**
 * leetcode 541
 *
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 */
public class No541 {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        No541 no541 = new No541();
        String res = no541.reverseStr(s, k);
        System.out.println(res);

    }

    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += k * 2) {
            int i = start;
            int j = Math.min(i + k - 1, a.length - 1);
            while (i < j) {
                char temp = a[i];
                a[i++] = a[j];
                a[j--] = temp;
            }
        }
        return new String(a);
    }
}
