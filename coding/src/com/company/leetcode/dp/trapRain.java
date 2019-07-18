package com.company.leetcode.dp;

/**
 * @author xxy
 * @date 2019/7/1
 * @description
 * ����?n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 *
 * ����һ �� ��̬�滮
 * ������ �����Ҽ�
 */
public class trapRain {
    public int trap(int[] height) {
        int len = height.length;
        if (len < 3)
            return 0;
        int ans = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i > -1 ; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
            ans += Math.min(right[i],left[i]) - height[i];
        }
        return ans;

    }
    public int trap2(int[] height) {
        if(height.length<=2){
            return 0;
        }
        int res = 0,maxHeight = height[0],maxIndex = 0;
        // �ҵ��м���ߵĵ� ��¼�߶ȼ��±�
        for(int i=0;i<height.length;i++){
            if(height[i]>maxHeight){
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        // �����
        int maxLeft = 0;
        for(int i = 0;i<maxIndex;i++){
            if(height[i]>maxLeft){
                maxLeft = height[i];
            }else{
                res +=(maxLeft-height[i]);
            }
        }
        // ���ұ�
        int maxRight = 0;
        for(int i=height.length-1;i>maxIndex;i--){
            if(height[i]>maxRight){
                maxRight = height[i];
            }else{
                res += (maxRight-height[i]);
            }
        }
        return res;

    }
}
