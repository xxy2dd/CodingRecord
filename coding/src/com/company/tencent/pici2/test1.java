package com.company.tencent.pici2;

import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/9/1
 * @description
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] box = new int[n];
        int[] key = new int[m];
        int box_odd =0,box_even=0,key_odd=0,key_even=0;
        for(int i=0;i<n;i++){
            box[i] = sc.nextInt();
            if(box[i]%2==0){
                box_even++;
            }else{
                box_odd++;
            }
        }
        for(int j=0;j<m;j++){
            key[j]=sc.nextInt();
            if(key[j]%2==0){
                key_even++;
            }else{
                key_odd++;
            }
        }
        if((box_even==0&&key_even==0)||(box_odd==0&&key_odd==0)){
            System.out.println(0);
        } else {
            int max = Math.min(key_even,box_odd)+Math.min(key_odd,box_even);
            System.out.println(max);
        }

    }
}
