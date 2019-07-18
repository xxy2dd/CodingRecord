package com.company.leetcode.dp;

/**
 * @author xxy
 * @date 2019/7/3
 * @description
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点?(i,?ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i?的两个端点分别为?(i,?ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与?x?轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且?n?的值至少为 2。
 * 思路：贪心  双指针
 */
public class maxArea {
    public int maxArea(int[] height) {
        if(height==null||height.length==0){
            return 0;
        }
        // 分别从首尾开始向内扫描，因为此时 容器的底边最长
        int left = 0, right = height.length-1;
        int res = 0,h=0;
        while(left<right){
            // 容器的高为两个柱子高度的较小者
            h = Math.min(height[left],height[right]);
            // 计算面积
            res = Math.max(res,(right-left)*h);
            // 要开始移动指针，这时要考虑左右指针当前的高度是大的还是小的，
            // 我们能够发现不管是左指针向右移动一位，还是右指针向左移动一位，容器的底都是一样的，都比原来减少了 1。
            // 这种情况下我们想要让指针移动后的容器面积增大，就要使移动后的容器的高尽量大，
            // 所以我们选择指针所指的高较小的那个指针进行移动，这样我们就保留了容器较高的那条边，放弃了较小的那条边，以获得有更高的边的机会。
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
