package com.company.xinlang;

/**
 * @author xxy
 * @date 2019/8/31
 * @description
 */
public class minStr {

    public static void main(String[] args){
        String[] list = new String[]{"3","4.3.5.4","2.10.3","2.4"};
        String res = getMinVersion(list);
        System.out.println(res);
    }
    public static String getMinVersion(String[] list) {
        if (list == null || list.length == 0) {
            return "";
        }
        int length = list.length;
        for (int i = 1; i < length; i++) {
            String[] temp1 = list[i - 1].split("\\.");
            String[] temp2 = list[i].split("\\.");
            int len = Math.min(temp1.length, temp2.length);
            for (int j = 0; j < len; j++) {
                if (Integer.parseInt(temp1[j]) < Integer.parseInt(temp2[j])) {
                    String temp = list[i-1];
                    list[i-1] = list[i];
                    list[i] = temp;
                    break;
                }
            }
        }
        return list[length - 1];
    }

}
