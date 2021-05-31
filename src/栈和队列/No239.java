package 栈和队列;

import java.util.LinkedList;

/**
 * No239 滑动窗口最大值
 *
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *
 *
 */
public class No239 {

    public static void main(String[] args) {
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        //窗口个数
        int[] res = new int[nums.length - k + 1];

        LinkedList<Integer> queue = new LinkedList<>();

        //遍历数组中元素，right表示滑动窗口右边界
        for (int right = 0; right < nums.length; right++) {
            //如果队列不为空且当前考察元素大于等于队尾元素，则将队尾元素移除。
            //直到，队列为空或者当前考察元素小于新的队尾元素
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast(); //说明此时会进来一个比队尾元素大的一个元素
            }
            //存元素下标
            queue.addLast(right);
            //计算窗口左侧边界
            int left = right - k + 1;
            //当队首元素的下标小于滑动窗口左侧边界left时
            //表示队首元素已经不再滑动窗口内，因此将其从队首移除
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }

            //数组下标从0开始，因此当窗口右边界right+1大于等于窗口大小k时，意味着窗口形成了，此时，队首元素就是该窗口内的最大值。
            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
