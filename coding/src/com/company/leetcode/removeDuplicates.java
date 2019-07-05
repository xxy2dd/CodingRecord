package com.company.leetcode;

/**
 * @author xxy
 * @date 2019/7/4
 * @description
 * ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 * ʾ��?1:
 * �������� nums = [1,1,2],
 * ����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2��
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * ʾ��?2:
 * ���� nums = [0,0,1,1,1,2,2,3,3,4],
 * ����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * ˵��:
 * Ϊʲô������ֵ��������������Ĵ���������?
 * ��ע�⣬�����������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�
 * ����������ڲ���������:
 * nums ���ԡ����á���ʽ���ݵġ�Ҳ����˵������ʵ�����κο���
 * int len = removeDuplicates(nums);
 * �ں������޸�����������ڵ������ǿɼ��ġ�
 * ������ĺ������صĳ���, �����ӡ�������иó��ȷ�Χ�ڵ�����Ԫ�ء�
 */
public class removeDuplicates {
    public static void main(String[] args){
        removeDuplicates m = new removeDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        m.removeDuplicates(nums);
    }
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) { return 0; }
        int index = 1;
        for(int i = 0; i<len;i++){
            int j=0;
            for(;j<index;j++){
                if(nums[j] == nums[i])
                    break;
            }
            if(j == index){
                nums[index++]=nums[i];
            }
        }
        return index;
    }
}
