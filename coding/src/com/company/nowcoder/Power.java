package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class Power {
    public double Power(double base, int exponent) {
        double res = 1,curr = base;
        int n;
        if(exponent>0){
            n=exponent;
        }else if(exponent<0){
            if(base==0) throw new RuntimeException("分母不能为0");
            n=-exponent;
        }else{// n==0
            // 0的0次方
            return 1;
        }
        while(n!=0){
            if((n&1)==1)
                res*=curr;
            // 翻倍
            curr*=curr;
            // 右移一位
            n>>=1;
        }
        return exponent>=0?res:(1/res);
    }
}
