package com.company.leetcode.greedy;

/**
 * @author xxy
 * @date 2019/7/28
 * @description
 * ������N��Сд��ĸ�ַ�����ɵ����飬ÿ���ַ���������ȡ�
 * ѡȡһ��ɾ���������У�����A�е�ÿ���ַ�����ɾ����Ӧÿ�����������ַ���
 * �����µ��ַ����д������¶��γ��С�
 * ѡ����һ��ɾ������ D����ִ��ɾ������֮��A ��ʣ���ÿһ�ж��Ƿǽ������еġ�
 * ���� D.length ����С����ֵ��
 */
public class minDeletionSize {
    public int minDeletionSize(String[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int r = A.length;
        int c = A[0].length();
        int count = 0;
        for(int i = 0;i<c;i++){
            for(int j = 0;j<r-1;j++){
                if(A[j].charAt(i)>A[j+1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
