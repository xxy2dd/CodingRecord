package com.company.nowcoder;

import java.util.ArrayList;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬
 * �����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix==null) return result;
        int r1 = 0 , r2 = matrix.length-1,c1 = 0,c2 = matrix[0].length-1;
        while(r1<=r2&&c1<=c2){
            for(int i=c1;i<=c2;i++){
                result.add(matrix[r1][i]);
            }
            for(int i=r1+1;i<=r2;i++){
                result.add(matrix[i][c2]);
            }
            if(r1!=r2){
                for(int i=c2-1;i>=c1;i--){
                    result.add(matrix[r2][i]);
                }
            }
            if(c1!=c2){
                for(int i=r2-1;i>r1;i--){
                    result.add(matrix[i][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return result;
    }
}