package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
 * �����������һ��n����̨���ܹ��ж�����������
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        if(target<=0){
            return -1;
        }else if(target==1){
            return 1;
        }else{
            return 2*JumpFloorII(target-1);
        }
    }
}
