package com.company.bytedance.dporgreedy;

/**
 * @author xxy
 * @date 2019/7/18
 * @description
 * ����һ���������飬���е�i��Ԫ�ش����˵�i��Ĺ�Ʊ�۸� ��?
 * ���һ���㷨����������������������Լ�������£�����Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ��:
 * �㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 * ������Ʊ�����޷��ڵڶ��������Ʊ (���䶳��Ϊ 1 ��)��
 *
 * ʾ��:
 * ����: [1,2,3,0,2]
 * ���: 3
 * ����: ��Ӧ�Ľ���״̬Ϊ: [����, ����, �䶳��, ����, ����]
 *
 * ˼·�� ��̬�滮
 * ״̬ת�Ʒ��̣�
 * sell[i] ��ʾ�� i ��ʱδ���й�Ʊ�ɻ�õ��������buy[i] ��ʾ�� i ��ʱ���й�Ʊ�ɻ�õ��������
 * ���� sell[i]��������������ֿ��ܣ�һ�ǽ������ɲ��ֹɸ�����״̬һ�������ǽ������˹�Ʊ
 * ���� buy[i]��������������ֿ��ܣ�һ�ǽ���ֹɸ�����״̬һ��������ǰ�����˹�Ʊ�����������Ʊ��
 * ��Ϊ���� cooldown ��ԭ�����Խ������ƱҪ׷�ݵ�ǰ���״̬��
 * ���յĽ��Ϊ���һ�첻���й�Ʊ��״̬���� sell[n - 1]��
 *
 * sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]);
 * cooldown[i] = sell[i-1];
 * buy[i] = Math.max(buy[i-1],cooldown[i-1]-prices[i]);
 */
public class maxProfit_cool {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int len = prices.length;
        int[] sell = new int[len];
        int[] cooldown = new int[len];
        int[] buy = new int[len];
        sell[0] = 0;
        buy[0] = -prices[0];
        for(int i=1;i<len;i++){
            sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]);
            cooldown[i] = sell[i-1];
            buy[i] = Math.max(buy[i-1],cooldown[i-1]-prices[i]);
        }
        return Math.max(sell[len-1],cooldown[len-1]);
    }
}
