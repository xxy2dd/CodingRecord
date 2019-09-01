package com.company.leetcode.dp;

/**
 * @author xxy
 * @date 2019/8/30
 * @description
 */
public class minPathSum {
    public static void main(String[] args){
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        minPathSum2(grid);
    }
    public static int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return Integer.MAX_VALUE;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0&&j==0){
                    dp[i][j] = grid[i][j];
                }else if(i==0){
                    dp[i][j] = dp[i][j-1]+grid[i][j];
                }else if(j==0){
                    dp[i][j] = dp[i-1][j]+grid[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];
                }
            }
        }
        return dp[row-1][col-1];

    }

    public static int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = (i == 1 ? 0 : dp[i - 1]) + grid[0][i - 1];
        }

        dp[0] = Integer.MAX_VALUE;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j - 1];
            }
        }
        return dp[n];

    }
}
