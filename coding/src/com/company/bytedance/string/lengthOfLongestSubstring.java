package com.company.bytedance.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 * ����: "pwwkew"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
 * ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
 */
public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int start = 0;
        Map<Character,Integer> map = new HashMap();
        for(int i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                start =Math.max(map.get(s.charAt(i))+1,start);
            }
            map.put(s.charAt(i),i);
            len = Math.max(len,i-start+1);
        }
        return len;

    }
}
