package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class Add {
    public int Add(int num1,int num2) {
        int temp;
        while(num2!=0){
            // ��� ��ͬ�ڲ����ǽ�λ���
            temp = num1^num2;
            // �����㣬Ȼ������1 ֻ���ǽ�λ�Ķ�����λ
            num2 = (num1&num2)<<1;
            // �ظ�������������ֱ��num2Ϊ0
            num1 = temp;
        }
        return num1;

    }
}
