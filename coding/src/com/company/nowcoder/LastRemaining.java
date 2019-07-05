package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/7/4
 * @description
 * 约瑟夫环问题！记住公式
 */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1){
            return -1;
        }
        if(n==1){
            return 0;
        }
        return (LastRemaining_Solution(n-1,m)+m)%n;
    }

    public int LastRemaining_Solution2(int n, int m) {
        if(n<1||m<1){
            return -1;
        }
        if(n==1){
            return 0;
        }
        int[] flag = new int[n];
        int step=0,count=n,i=-1;
        while(count>0){
            i++;
            if(flag[i%n]==-1){
                continue;
            }
            step++;
            if(step==m){
                count--;
                flag[i%n]=-1;
                step=0;
            }
        }
        return i%n;
    }
}
