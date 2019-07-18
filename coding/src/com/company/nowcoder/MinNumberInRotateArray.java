package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 *
 * ˼·��
 *
 * ���ö��ַ����������⣬
 * mid = low + (high - low)/2
 * ��Ҫ�������������
 * (1)array[mid] > array[high]:
 * �������������array����[3,4,5,6,0,1,2]����ʱ��С����һ����mid���ұߡ�
 * low = mid + 1
 * (2)array[mid] == array[high]:
 * �������������array���� [1,0,1,1,1] ����[1,1,1,0,1]��
 * ��ʱ��С���ֲ����ж���mid��� �����ұ�,��ʱֻ��һ��һ���� ��
 * high = high - 1
 * (3)array[mid] < array[high]:
 * �������������array����[2,2,3,4,5,6,6],��ʱ��С����һ������array[mid]������mid����
 * �ߡ���Ϊ�ұ߱�Ȼ���ǵ����ġ�
 * high = mid
 * ע�������и��ӣ��������ѯ�ķ�Χ���ֻʣ����������ômid һ����ָ���±꿿ǰ������
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int low = 0 ; int high = array.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return array[low];

    }
}
