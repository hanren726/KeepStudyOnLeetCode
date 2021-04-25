import java.util.HashMap;
import java.util.Map;

/**
 * No454 四数相加 II
 *
 * 给定四个包含整数的数组列表A , B , C , D ,计算有多少个元组 (i, j, k, l)，使得A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过231 - 1 。
 *
 *
 */
public class No454 {

    public static void main(String[] args) {

        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2, -1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};

        No454 no454 = new No454();
        System.out.println(no454.fourSumCount(A, B, C, D));
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: nums1) {
            for(int b: nums2) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        int res = 0;
        for(int a: nums3) {
            for(int b: nums4) {
                if (map.containsKey(-a-b)) {
                    res += map.getOrDefault(-a - b, 0);
                }
            }
        }
        return res;
    }
}
