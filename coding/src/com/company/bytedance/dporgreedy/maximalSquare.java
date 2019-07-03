package com.company.bytedance.dporgreedy;

/**
 * @author xxy
 * @date 2019/7/2
 * @description
 * ��һ���� 0 �� 1 ��ɵĶ�ά�����ڣ��ҵ�ֻ���� 1 ����������Σ��������������
 * ˼·����̬�滮
 * �������ж���ĳ����Ϊ���������½�ʱ����������ʱ���������Ϸ����󷽺����Ϸ�������Ҳһ����ĳ�������ε����½ǣ�
 * ����õ�Ϊ���½ǵ����������������Լ��ˡ����Ƕ��Ե��жϣ�
 * �Ǿ������������α߳��أ�����֪�����õ�Ϊ���½ǵ������ε����߳������������Ϸ����󷽺����Ϸ�Ϊ���½ǵ������εı߳���1��
 * ��õ�������������Ϸ����󷽺����Ϸ�Ϊ���½ǵ������εĴ�С��һ���ģ��������ϸõ�Ϳ��Թ���һ������������Ρ�
 * ����������Ϸ����󷽺����Ϸ�Ϊ���½ǵ������εĴ�С��һ�����������ͻ�ȱ��ĳ�����䣬��ʱ��ֻ��ȡ����������������С�������εı߳���1�ˡ�
 * ����dpi��ʾ��i,jΪ���½ǵ������ε����߳�������
 * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
 * ��Ȼ������������ԭ�����б�������0�Ļ�����dpi�϶�����0�ˡ�
 */
public class maximalSquare {
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