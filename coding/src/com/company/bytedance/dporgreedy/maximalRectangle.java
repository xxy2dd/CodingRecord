package com.company.bytedance.dporgreedy;

/**
 * @author xxy
 * @date 2019/7/2
 * @description
 * ����һ�������� 0 �� 1 �Ķ�ά�����ƾ����ҳ�ֻ���� 1 �������Σ������������
 */
public class maximalRectangle {
    public static void main(String[] args){
        maximalRectangle m = new maximalRectangle();
        char[][] c = {{'1','0','1','0'},{'0', '1','0','1'},{'1','1', '1','1'},{'1','1','1','1'},{'0','0','1','0'}};

        m.maximalRectangle(c);
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int result = 0;
        int row = matrix.length,col = matrix[0].length;
        // ��¼��߽�
        int[] L = new int[col];
        // ��¼�ұ߽�
        int[] R = new int[col];
        // ��¼��
        int[] H = new int[col];
        // ��ʼ��
        for(int i=0;i<col;i++){
            L[i] = 0;
            R[i] = col;
            H[i] = 0;
        }
        // ����ÿһ��
        for(int i = 0;i<row;i++){
            int left = 0;
            for(int j = 0;j<col;j++){
                // ���� 1 ����߽�ȡL[j] �� left�ϴ��ߣ��߶�+1
                if(matrix[i][j]=='1'){
                    L[j] = Math.max(L[j],left);
                    H[j] +=1;
                }else{
                    // ����0������״̬��λ, left = j+1
                    L[j] = 0;
                    R[j] = col;
                    H[j] = 0;
                    left=j+ 1;
                }
            }
            // �����������ұ߽�
            int right = col;
            for(int j=col-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    R[j] = Math.min(R[j],right);
                    result = Math.max(result,H[j]*(R[j]-L[j]));
                }else{
                    right = j;
                }
            }
        }
        return result;
    }
}
