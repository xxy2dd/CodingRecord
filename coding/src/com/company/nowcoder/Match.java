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
        // 有效性检验：str到尾，pattern到尾，匹配成功
        if(sindex >= str.length && pindex == pattern.length) {
            return true;
        }
        // pattern先到尾，匹配失败
        if(pindex >= pattern.length && sindex < str.length) {
            return false;
        }
        // 模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式
        // 1、模式后移2字符，相当于x*被忽略；2、字符串后移1字符，模式后移2字符；3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
        // 如不匹配，模式后移2位
        if(pindex+1 < pattern.length && pattern[pindex+1] == '*'){
            if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.') ){
                return matchCore(str, sindex, pindex+2, pattern) ||
                        matchCore(str, sindex+1, pindex+2, pattern ) ||
                        matchCore(str, sindex+1, pindex, pattern);
            }else{
                return matchCore(str, sindex, pindex+2, pattern);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.'))
            return matchCore(str, sindex+1, pindex+1, pattern);
        return false;

    }

}
