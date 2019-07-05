package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class Match {
    public static void main(String[] args){
        String str = "aaa";
        String pattern = "ab*ac*a";
        Match m = new Match();
        m.match(str.toCharArray(),pattern.toCharArray());
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
        if(sindex >= str.length && pindex == pattern.length)
            return true;
        if(pindex >= pattern.length && sindex < str.length)
            return false;
        if(pindex+1 < pattern.length && pattern[pindex+1] == '*'){
            if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.') ){
                return matchCore(str, sindex, pindex+2, pattern) ||
                        matchCore(str, sindex+1, pindex+2, pattern ) ||
                        matchCore(str, sindex+1, pindex, pattern);
            }else{
                return matchCore(str, sindex, pindex+2, pattern);
            }
        }
        if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.'))
            return matchCore(str, sindex+1, pindex+1, pattern);
        return false;

    }

}
