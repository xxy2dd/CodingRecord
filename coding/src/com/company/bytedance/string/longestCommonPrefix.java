package com.company.bytedance.string;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * ��дһ�������������ַ��������е������ǰ׺��
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""
 * ����: ["flower","flow","flight"]
 * ���: "fl"
 */
public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        int index = 0;
        // �Ե�һ���ַ���Ϊ��׼
        for (int i = 0;i<strs[0].length();i++){
            // ��ǰ�ַ�
            char current = strs[0].charAt(index);
            // �����ַ�������
            for (String str:strs){
                // �������ַ����ĳ��Ⱥ͵�ǰ�����ĳ�����Ȼ��ߵ�ǰ�ַ��͸��ַ����Ķ�Ӧλ���ַ���һ��
                // ��������ַ��ģ�0��index�����ַ���
                if (str.length()== i || current!=str.charAt(i)){
                    return str.substring(0,index);
                }
            }
            index++;
        }
        // �������˻�û�з��أ�˵����һ���ַ������������ǰ׺
        return strs[0].substring(0, index);
    }
}
