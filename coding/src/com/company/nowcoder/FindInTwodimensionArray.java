package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����
 * ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 */
public class FindInTwodimensionArray {
    public boolean Find(int target, int [][] array) {
        if(array==null ||array.length==0||array[0].length==0)
            return false;
        int rowCount = array.length;
        int colCount = array[0].length;
        int i,j;
        // ���ݶ�ά��������ԣ������Ͻǵ�����ʼ����
        for(i=0,j=colCount-1;i<rowCount&&j>=0;){
            if(target==array[i][j]){
                return true;
            }
            if(target<array[i][j]){
                j--;
                continue;
            }
            if(target>array[i][j]){
                i++;
                continue;
            }

        }
        return false;
    }
}
