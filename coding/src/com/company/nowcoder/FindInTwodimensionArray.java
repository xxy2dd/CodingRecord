package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInTwodimensionArray {
    public boolean Find(int target, int [][] array) {
        if(array==null ||array.length==0||array[0].length==0)
            return false;
        int rowCount = array.length;
        int colCount = array[0].length;
        int i,j;
        // 根据二维数组的特性，从右上角的数开始遍历
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
