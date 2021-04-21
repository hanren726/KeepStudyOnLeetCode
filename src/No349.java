import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 */
public class No349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int j : nums1) {
            set1.add(j);
        }
        for (int j : nums2) {
            set2.add(j);
        }
        return getRes(set1, set2);
    }

    public int[] getRes(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getRes(set2, set1);
        }
        Set<Integer> resSet = new HashSet<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                resSet.add(num);
            }
        }
        int[] res = new int[resSet.size()];
        int i=0;
        for(int num : resSet) {
            res[i++] = num;
        }
        return res;
    }
}
