package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuffer b=new StringBuffer();
        String s=str.toString();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==' '){
                b.append("%20");
                continue;
            }
            b.append(ch);
        }
        return b.toString();
    }
}
