package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0 || array==null){
            return 0;
        }
        int len = array.length/2;
        int majority = array[0];
        for(int i=1,cnt=1;i<array.length;i++){
            cnt = majority==array[i]?cnt+1:cnt-1;
            if(cnt==0){
                majority = array[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        for(int val:array){
            if(val==majority){
                cnt++;
            }
        }
        return cnt>len?majority:0;
    }
}
