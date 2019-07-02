package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ��
 * ��������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý����
 * ����,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�
 * ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)����һ�����飬��������������������еĺͣ���᲻�ᱻ������ס��(�������ĳ���������1)
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0){
            return 0;
        }
        int cur = array[0];
        int max = array[0];
        for(int i = 1;i<array.length;i++){
            cur = cur>0 ? cur+array[i] : array[i];
            if(max<cur){
                max = cur;
            }
        }
        return max;
    }
}
