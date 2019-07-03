package com.company.bytedance.dporgreedy;

/**
 * @author xxy
 * @date 2019/7/2
 * @description
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积
 */
public class maximalRectangle {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++){
            if(matrix[i][0]=='1'){
                dp[i][0] = 1;
                res = 1;
            }
        }
        for(int j=0;j<col;j++){
            if(matrix[0][j]=='1'){
                dp[0][j] = 1;
                res = 1;

            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res*res;

    }
}
