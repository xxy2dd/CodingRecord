package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 */
public class RectCover {
    public int RectCover(int target) {
        if(target<=0){
            return 0;
        }
        if(target==1||target==2){
            return target;
        }else{
            return RectCover(target-1)+RectCover(target-2);
        }
    }
}
