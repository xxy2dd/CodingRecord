package com.company.bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xxy
 * @date 2019/6/30
 * @description ����һ������ n ������������ nums��
 * �ж� nums ���Ƿ��������Ԫ�� a��b��c ��ʹ�� a + b + c = 0 ��
 * �ҳ��������������Ҳ��ظ�����Ԫ�顣
 * ע�⣺���в����԰����ظ�����Ԫ�顣
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        // �ȶ������������
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // �������ĺ�Ϊ0�����ȻҪ���ڸ�����
            // ��Ϊ�Ѿ����ź�������飬С�ڵ���0 ������Ȼλ��ǰ�棬�������������0 ������ֱ������ѭ��
            if (nums[i] > 0) {
                break;
            }
            // ��Ϊ���ܰ����ظ������֣�����Ҫ�����������������ж��Ƿ����
            // ��������continue
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // ������֮������ת��Ϊ����֮��
            int reverse = -nums[i];
            // ��ʣ�������ж��ֲ����Ƿ�������������������
            int j = i + 1;
            int k = nums.length - 1;
            // ע��ѭ����ֹ���� j<k
            while (j < k) {
                // �����ȣ��򽫵�ǰ���������������С���ΪҪ�ҵ�ȫ���������������У����Լ������±���
                if (nums[j] + nums[k] == reverse) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);

                    j++;
                    // ע���ж��Ƿ�������������ȣ����������
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    k--;
                    // ע���ж��Ƿ�������������ȣ����������
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }

                }
                // �������֮�ͱȽ��С ˵�� j Ҫ���� ʹ������
                else if (nums[j] + nums[k] < reverse) {
                    j++;
                }
                // �������֮�ͱȽ���� ˵�� k Ҫǰ�� ʹ�����С
                else {
                    k--;
                }
            }
        }
        return res;

    }
}
