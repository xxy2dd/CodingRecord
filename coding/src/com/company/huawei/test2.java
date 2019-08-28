package com.company.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/8/28
 * @description
 */
public class test2 {

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2,3,4,5},{11,12,13,14,15},{21,22,23,24,25},{31,32,33,34,35},{41,42,43,44,45}};
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int[] arr = new int[6];
            for(int i=0;i<6;i++){
               arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int[] row = new int[6];
            int[] col = new int[6];
            row[0] = arr[0]/10;
            col[0] = arr[0]%10;
            int i=1;
            for(;i<6;i++){
                row[i] = arr[i]/10;
                col[i] = arr[i]%10;
               /* if(col[i]-col[i-1]>1||row[i]-row[i-1]>1){
                    System.out.println(0);
                    break;
                }*/
                if((row[i]==row[i-1]&&col[i]-col[i-1]>1)||(row[i]-row[i-1]>1)){
                    System.out.println(0);
                    break;
                }
                if(row[i]-row[i-1]==1){
                    int j=0;
                    for(;j<i;j++){
                        if(col[j]==col[i]){
                            break;
                        }
                    }
                    if(j==i){
                        System.out.println(0);
                        break;
                    }
                }
            }
            if(i==6){
                System.out.println(1);
            }
        }
    }
}
