package com.company.nowcoder;

import java.util.Arrays;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,
 * ����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
 * ������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,
 * ��������,������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
 * �����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����
 * LL����ȥ��������Ʊ����
 * ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Σ�
 * ����������˳�Ӿ����true����������false��
 * Ϊ�˷������,�������Ϊ��С����0��
 */
public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        if(numbers==null || numbers.length<5){
            return false;
        }
        Arrays.sort(numbers);
        int count = 0;
        int gap = 0;
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]==0){
                count++;
                continue;
            }
            if(numbers[i]==numbers[i+1]){
                return false;
            }
            gap += numbers[i+1]-numbers[i]-1;
        }
        if(gap<=count){
            return true;
        }
        return false;
    }
}
