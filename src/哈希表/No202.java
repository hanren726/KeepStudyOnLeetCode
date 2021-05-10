package 哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * 202题 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 *
 */
public class No202 {

    public static void main(String[] args) {
        No202 no202 = new No202();
        System.out.println("result=" + no202.isHappy(2));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public int getNext(int n) {
        int res = 0;
        while (n > 0) {
            int cur = n % 10;
            n = n / 10;
            res += cur * cur;
        }
        return res;
    }
}
