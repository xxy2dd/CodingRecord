package com.company.leetcode.string;

import java.util.LinkedList;

/**
 * @author xxy
 * @date 2019/8/18
 * @description
 * s = "3[a]2[bc]", ���� "aaabcbc".
 * s = "3[a2[c]]", ���� "accaccacc".
 * s = "2[abc]3[cd]ef", ���� "abcabccdcdcdef".

 */
public class decodeString {
    /**
     * ����ջ��
     * ʱ�临�Ӷ�O��n���ռ临�Ӷ� O��n��
     */
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        LinkedList<Integer> countStack = new LinkedList<>();
        LinkedList<String> resStack = new LinkedList<>();
        for(Character c:s.toCharArray()){
            if(c == '['){
                countStack.addLast(count);
                resStack.addLast(sb.toString());
                count = 0;
                sb = new StringBuilder();
            }else if(c == ']'){
                StringBuilder temp = new StringBuilder();
                int curCount = countStack.removeLast();
                for(int i=0;i<curCount;i++){
                    temp.append(sb);
                }
                sb = new StringBuilder(resStack.removeLast()+temp);
            }else if(c>='0'&&c<='9'){
                // ���㱶��
                count = count*10+Integer.parseInt(c+"");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
