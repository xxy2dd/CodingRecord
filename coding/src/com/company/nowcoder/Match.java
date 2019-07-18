package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class Match {
    public static void main(String[] args){
        String str = "aa";
        String pattern = "a*";
        Match m = new Match();
        boolean res = m.match(str.toCharArray(),pattern.toCharArray());
        System.out.println(res);
    }
    public boolean match(char[] str, char[] pattern)
    {
        if(str==null && pattern==null){
            return true;
        }
        if(str!=null && pattern==null){
            return false;
        }
        int sindex = 0, pindex = 0;
        return matchCore(str, sindex, pindex, pattern);
    }
    public boolean matchCore(char[] str, int sindex, int pindex, char[] pattern){
        // ��Ч�Լ��飺str��β��pattern��β��ƥ��ɹ�
        if(sindex >= str.length && pindex == pattern.length) {
            return true;
        }
        // pattern�ȵ�β��ƥ��ʧ��
        if(pindex >= pattern.length && sindex < str.length) {
            return false;
        }
        // ģʽ��2����*�����ַ�����1����ģʽ��1��ƥ��,��3��ƥ��ģʽ
        // 1��ģʽ����2�ַ����൱��x*�����ԣ�2���ַ�������1�ַ���ģʽ����2�ַ���3���ַ�������1�ַ���ģʽ���䣬������ƥ���ַ���һλ����Ϊ*����ƥ���λ��
        // �粻ƥ�䣬ģʽ����2λ
        if(pindex+1 < pattern.length && pattern[pindex+1] == '*'){
            if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.') ){
                return matchCore(str, sindex, pindex+2, pattern) ||
                        matchCore(str, sindex+1, pindex+2, pattern ) ||
                        matchCore(str, sindex+1, pindex, pattern);
            }else{
                return matchCore(str, sindex, pindex+2, pattern);
            }
        }
        //ģʽ��2������*�����ַ�����1����ģʽ��1��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
        if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.'))
            return matchCore(str, sindex+1, pindex+1, pattern);
        return false;

    }

}
