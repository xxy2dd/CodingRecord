package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum {
    public int Sum_Solution(int n) {
        int ans = n;
        boolean flag = (ans>0) && ((ans += Sum_Solution(n - 1))>0);
        return ans;
    }
}
