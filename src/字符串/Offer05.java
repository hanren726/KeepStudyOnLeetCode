package 字符串;

/**
 * 剑指 Offer 05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class Offer05 {

    public static void main(String[] args) {
        String s = "    ";
        Offer05 offer05 = new Offer05();
        System.out.println(offer05.replaceSpace(s));
    }

    public String replaceSpace(String s) {
        char[] arr = new char[s.length() * 3];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ' ') {
                arr[index++] = '%';
                arr[index++] = '2';
                arr[index++] = '0';
            } else {
                arr[index++] = cur;
            }
        }
        return new String(arr);
    }

}
