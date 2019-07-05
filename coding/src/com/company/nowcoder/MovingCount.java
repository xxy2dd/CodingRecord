package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/7/5
 * @description
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        return movingcount(threshold, rows, cols, 0, 0, visited);
    }

    public int movingcount(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        // 判断是否合法
        if (check(threshold, rows, cols, row, col, visited)) {
            // 合法就设置访问位为true
            visited[row * cols + col] = true;
            // 递归上下左右四个方向是否符合
            count = 1
                    + movingcount(threshold, rows, cols, row - 1, col, visited)
                    + movingcount(threshold, rows, cols, row, col - 1, visited)
                    + movingcount(threshold, rows, cols, row + 1, col, visited)
                    + movingcount(threshold, rows, cols, row, col + 1, visited);
        }
        return count;

    }

    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        return col >= 0 && col < cols
                && row >= 0 && row < rows
                && !visited[row * cols + col]
                && (getSum(col) + getSum(row) <= threshold);
    }

    public int getSum(int num) {
        int res = 0;
        while (num > 0) {
            res += (num % 10);
            num /= 10;
        }
        return res;
    }
}
