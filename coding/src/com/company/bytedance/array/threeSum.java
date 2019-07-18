package com.company.bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xxy
 * @date 2019/6/30
 * @description 给定一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        // 先对数组进行排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 三个数的和为0，则必然要存在负数，
            // 因为已经是排好序的数组，小于等于0 的数必然位于前面，如果遍历到大于0 的数，直接跳出循环
            if (nums[i] > 0) {
                break;
            }
            // 因为不能包括重复的数字，所以要对相邻两个数进行判断是否相等
            // 如果相等则continue
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 将三数之和问题转化为两数之和
            int reverse = -nums[i];
            // 在剩余序列中二分查找是否与满足条件的两个数
            int j = i + 1;
            int k = nums.length - 1;
            // 注意循环终止条件 j<k
            while (j < k) {
                // 如果相等，则将当前三个数加入结果序列。因为要找到全部满足条件的序列，所以继续向下遍历
                if (nums[j] + nums[k] == reverse) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);

                    j++;
                    // 注意判断是否相邻两个数相等，相等则跳过
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    k--;
                    // 注意判断是否相邻两个数相等，相等则跳过
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }

                }
                // 如果两数之和比结果小 说明 j 要后移 使结果变大
                else if (nums[j] + nums[k] < reverse) {
                    j++;
                }
                // 如果两数之和比结果大 说明 k 要前移 使结果变小
                else {
                    k--;
                }
            }
        }
        return res;

    }
}
