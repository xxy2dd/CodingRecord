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
            if(base==0) throw new RuntimeException("��ĸ����Ϊ0");
            n=-exponent;
        }else{// n==0
            // 0��0�η�
            return 1;
        }
        while(n!=0){
            if((n&1)==1)
                res*=curr;
            // ����
            curr*=curr;
            // ����һλ
            n>>=1;
        }
        return exponent>=0?res:(1/res);
    }
}
