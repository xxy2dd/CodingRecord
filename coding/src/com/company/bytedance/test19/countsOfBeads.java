package com.company.bytedance.test19;

import java.util.*;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * �ִ����ˣ��н������㶩����һ������n����ɫ������ִ�����ÿ������Ҫô��ɫ��ҪôͿ����������ɫ��
 * Ϊ��ʹ�ִ���ɫ�ʿ���������ô����������Ҫ���ִ��ϵ�����һ����ɫ����������ɫ����������������m���������������һ�Σ�ע�������ִ���һ�����Σ���
 * �ִ��ϵ���ɫһ����c�֡����ڰ�˳ʱ���������n��������ִ��ϣ�ÿ������������������ɫ�ֱ�����Щ��
 * �����жϸ��ִ����ж�������ɫ������Ҫ��
 * ��ѯ���ж�������ɫ����������m�������г������������Ρ�
 * ���룺
 * ��һ������n��m��c���������ÿո������
 * (1 <= n <= 10000, 1 <= m <= 1000, 1 <= c <= 50) ������n��ÿ�еĵ�һ����num_i(0 <= num_i <= c)��ʾ��i�������ж�������ɫ��
 * ���������ζ���num_i�����֣�ÿ������x��ʾ��i�������ϰ�����x����ɫ(1 <= x <= c)
 */
public class countsOfBeads {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int c = scan.nextInt();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            int num_i = scan.nextInt();
            for(int j = 0;j<num_i;j++){
                int color = scan.nextInt();
                List<Integer> list = new LinkedList<>();
                if(map.containsKey(color)){
                    list = map.get(color);
                }
                list.add(i+1);
                map.put(color,list);
            }
        }
        int count = 0;
        for(int k = 0;k<=c;k++){
            List<Integer> list =map.get(k);
            if(list!=null){
                for(int i=0;i<list.size()-1;i++){
                    if(list.size()>1&&(n+list.get(0)-list.get(list.size()-1))<m){
                        count++;
                        break;
                    }
                    if(list.get(i+1)-list.get(i)<m){
                        count++;
                        break;
                    }

                }
            }
        }
        System.out.println(count);
    }
}
