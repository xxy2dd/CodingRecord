package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣�
 * ���������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P��
 * ����P��1000000007ȡģ�Ľ������� �����P%1000000007
 *
 * ˼·��

������������ָ��ֱ�ָ�������������ĩβ����ÿ�αȽ�����ָ��ָ������֡�
�����һ���������е����ִ��ڵڶ��������е����֣��򹹳�����ԣ���������Ե���Ŀ���ڵڶ�����������ʣ�����ֵĸ�����
����ͼ��a���ͣ�c����ʾ�������һ�����������С�ڻ���ڵڶ��������е����֣��򲻹�������ԣ���ͼb��ʾ��
ÿһ�αȽϵ�ʱ�����Ƕ��ѽϴ�����ִӺ�����ǰ���Ƶ�һ�����������У�ȷ�� �������飨��Ϊcopy�� �е������ǵ�������ġ�
�ڰѽϴ�����ָ��Ƶ���������֮�󣬰Ѷ�Ӧ��ָ����ǰ�ƶ�һλ��������������һ�ֱȽϡ�
 */
public class InversePairs {
    private long cnt = 0;
    private int[] temp;
    public int InversePairs(int [] array) {
        temp = new int[array.length];
        // �鲢����
        mergeSort(array,0,array.length-1);
        return (int)(cnt%1000000007);
    }
    private void mergeSort(int[] nums,int l,int h){
        if(h-l<1){
            return;
        }
        int m = l+(h-l)/2;
        mergeSort(nums,l,m);
        mergeSort(nums,m+1,h);
        merge(nums,l,m,h);
    }

    private void merge(int[] nums,int l,int m,int h){
        int i = l,j=m+1,k =l;
        while(i<=m||j<=h){
            if(i>m){
                temp[k] = nums[j++];
            }else if(j>h){
                temp[k] = nums[i++];
            }else if(nums[i]<nums[j]){
                temp[k] = nums[i++];
            }else{
                temp[k] = nums[j++];
                this.cnt += m-i+1;
            }
            k++;
        }
        for(k=l;k<=h;k++){
            nums[k] = temp[k];
        }
    }
}
