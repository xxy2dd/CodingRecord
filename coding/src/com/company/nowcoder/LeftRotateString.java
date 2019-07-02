package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * �����������һ����λָ�����ѭ�����ƣ�ROL����
 * �����и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * ����һ���������ַ�����S���������ѭ������Kλ������������
 * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
 * �ǲ��Ǻܼ򵥣�OK���㶨����
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        char[] chars = str.toCharArray();
        if (chars.length < n) {
            return "";
        }
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);

        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
