package com.company.bytedance.dporgreedy;

/**
 * @author xxy
 * @date 2019/7/2
 * @description 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积
 */
public class maximalRectangle {
    public static void main(String[] args) {
        maximalRectangle m = new maximalRectangle();
        char[][] c = {{'1', '0', '1', '0'}, {'0', '1', '0', '1'}, {'1', '1', '1', '1'}, {'1', '1', '1', '1'}, {'0', '0', '1', '0'}};

        m.maximalRectangle(c);
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int result = 0;
        int row = matrix.length, col = matrix[0].length;
        // 记录左边界
        int[] L = new int[col];
        // 记录右边界
        int[] R = new int[col];
        // 记录高
        int[] H = new int[col];
        // 初始化
        for (int i = 0; i < col; i++) {
            L[i] = 0;
            R[i] = col;
            H[i] = 0;
        }
        // 遍历每一行
        for (int i = 0; i < row; i++) {
            // left 记录 下标
            int left = 0;
            // 从左向右遍历每一列记录左边界
            for (int j = 0; j < col; j++) {
                // 遇到 1 ，左边界取 L[j] 和 left 较大者，高度+1
                if (matrix[i][j] == '1') {
                    L[j] = Math.max(L[j], left);
                    H[j] += 1;
                } else {
                    // 遇到0，所有状态归位, left = j+1
                    L[j] = 0;
                    R[j] = col;
                    H[j] = 0;
                    left = j + 1;
                }
            }
            // 从右向左遍历每一列记录右边界
            int right = col;
            for (int j = col - 1; j >= 0; j--) {
                // 遇到 1 ，右边界取 R[j] 和 right 较小者，同时计算此时的面积，
                if (matrix[i][j] == '1') {
                    R[j] = Math.min(R[j], right);
                    result = Math.max(result, H[j] * (R[j] - L[j]));
                } else {
                    right = j;
                }
            }
        }
        return result;
    }
}
