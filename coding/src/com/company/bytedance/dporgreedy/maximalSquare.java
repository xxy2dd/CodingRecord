package com.company.bytedance.dporgreedy;

/**
 * @author xxy
 * @date 2019/7/2
 * @description
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 思路：动态规划
 * 当我们判断以某个点为正方形右下角时最大的正方形时，那它的上方，左方和左上方三个点也一定是某个正方形的右下角，
 * 否则该点为右下角的正方形最大就是它自己了。这是定性的判断，
 * 那具体的最大正方形边长呢？我们知道，该点为右下角的正方形的最大边长，最多比它的上方，左方和左上方为右下角的正方形的边长多1，
 * 最好的情况是是它的上方，左方和左上方为右下角的正方形的大小都一样的，这样加上该点就可以构成一个更大的正方形。
 * 但如果它的上方，左方和左上方为右下角的正方形的大小不一样，合起来就会缺了某个角落，这时候只能取那三个正方形中最小的正方形的边长加1了。
 * 假设dpi表示以i,j为右下角的正方形的最大边长，则有
 * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
 * 当然，如果这个点在原矩阵中本身就是0的话，那dpi肯定就是0了。
 */
public class maximalSquare {
    public int maximalSquare(char[][] matrix) {
        // 判断数组是否为空
        if(matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        int[][] dp = new int[row][col];
        // 初始化 dp 数组
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
        // 遍历数组 利用动态规划公式
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
                // 更新最大边长
                res = Math.max(res,dp[i][j]);
            }
        }
        return res*res;

    }
}
