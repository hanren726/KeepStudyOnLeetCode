package 数组;//leetcode 59
//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

public class No59 {

    public static void main(String[] args) {
        int[][] res = genMatrix(4);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static int[][] genMatrix(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] res = new int[n][n];
        int row = 0;
        int col = 0;
        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directIndex = 0;
        while (curNum <= maxNum) {
            res[row][col] = curNum;
            curNum++;
            int nextRow = row + direct[directIndex][0];
            int nextCol = col + direct[directIndex][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || res[nextRow][nextCol] != 0) {
                directIndex = (directIndex + 1) % 4;
            }
            row = row + direct[directIndex][0];
            col = col + direct[directIndex][1];
        }
        return res;
    }
}
