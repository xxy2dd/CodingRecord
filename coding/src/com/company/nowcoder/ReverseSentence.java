package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        int len = str.length();
        char[] chars = str.toCharArray();
        int i = 0 , j =0;
        while(j<=len){
            if(j==len||chars[j]==' '){
                reverse(chars,i,j-1);
                i = j+1;
            }
            j++;
        }
        reverse(chars,0,len-1);
        return new String(chars);
    }
    private void reverse(char[] c,int i,int j){
        while(i<j){
            swap(c,i++,j--);
        }
    }
    private void swap(char[] c,int i,int j){
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
