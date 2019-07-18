package com.company.leetcode.dp;

/**
 * @author xxy
 * @date 2019/7/3
 * @description
 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ����?(i,?ai) ��
 * �������ڻ� n ����ֱ�ߣ���ֱ�� i?�������˵�ֱ�Ϊ?(i,?ai) �� (i, 0)���ҳ����е������ߣ�
 * ʹ��������?x?�Ṳͬ���ɵ�����������������ˮ��
 * ˵�����㲻����б��������?n?��ֵ����Ϊ 2��
 * ˼·��̰��  ˫ָ��
 */
public class maxArea {
    public int maxArea(int[] height) {
        if(height==null||height.length==0){
            return 0;
        }
        // �ֱ����β��ʼ����ɨ�裬��Ϊ��ʱ �����ĵױ��
        int left = 0, right = height.length-1;
        int res = 0,h=0;
        while(left<right){
            // �����ĸ�Ϊ�������Ӹ߶ȵĽ�С��
            h = Math.min(height[left],height[right]);
            // �������
            res = Math.max(res,(right-left)*h);
            // Ҫ��ʼ�ƶ�ָ�룬��ʱҪ��������ָ�뵱ǰ�ĸ߶��Ǵ�Ļ���С�ģ�
            // �����ܹ����ֲ�������ָ�������ƶ�һλ��������ָ�������ƶ�һλ�������ĵ׶���һ���ģ�����ԭ�������� 1��
            // ���������������Ҫ��ָ���ƶ��������������󣬾�Ҫʹ�ƶ���������ĸ߾�����
            // ��������ѡ��ָ����ָ�ĸ߽�С���Ǹ�ָ������ƶ����������Ǿͱ����������ϸߵ������ߣ������˽�С�������ߣ��Ի���и��ߵıߵĻ��ᡣ
            while(height[right]<=h&&left<right){
                right--;
            }
            while(height[left]<=h&&left<right){
                left++;
            }
        }
        return res;
    }
}
