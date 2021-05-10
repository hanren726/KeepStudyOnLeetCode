package 数组;

//leetcode第27题 移动元素
public class No27 {

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 2};
        int res = removeElement(data, 2);
        System.out.println(res);
    }

    public static int removeElement(int[] arr, int val) {
        int i = 0; //慢指针
        for (int j = 0; j < arr.length; j++) { //快指针往后走
            if (arr[j] != val) { //遇到不等于val的值的时候
                arr[i] = arr[j]; //把当前值赋值给慢指针所在位置的值， 保证【0， i）直接都是不等于val的数
                i++;             //慢指针前移
            }
        }
        return i;
    }
}
