package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ��1+2+3+...+n��
 * Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 */
public class Sum {
    public int Sum_Solution(int n) {
        int ans = n;
        boolean flag = (ans>0) && ((ans += Sum_Solution(n - 1))>0);
        return ans;
    }
}
