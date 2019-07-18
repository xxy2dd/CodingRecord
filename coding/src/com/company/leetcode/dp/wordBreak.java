package com.company.leetcode.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xxy
 * @date 2019/7/3
 * @description
 * ����һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict��
 * �ж�?s �Ƿ���Ա��ո���Ϊһ���������ֵ��г��ֵĵ��ʡ�
 * ˵����
 * ���ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
 * ����Լ����ֵ���û���ظ��ĵ��ʡ�
 *
 * ˼·����̬�滮
 * f[i]��ʾ�ַ���s��ǰi���ַ��ܷ��ֳ�wordDict��
 */
public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;
        Set<String> wordDictSet = new HashSet<>(wordDict);
        for(int i = 0;i<s.length();i++){
            if(!f[i]){
                continue;
            }
            for(String d:wordDictSet){
                if((i+d.length()<=s.length())&&s.substring(i,i+d.length()).equals(d)){
                    f[i+d.length()]=true;
                }
            }
        }
        return f[s.length()];
    }
}
