package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.
 * �򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
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
