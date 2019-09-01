package com.company.leetcode.dp;

/**
 * @author xxy
 * @date 2019/7/2
 * @description
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
 */
public class longestPalindrome {
    public static void main(String[] args) {
        String s = "xvbbababd";
        String res = longestPalindrom3(s);
        System.out.println(res);
    }

    /**
     * ����һ�������ⷨ
     * ʱ�临�Ӷ� O��n^3��
     * �ռ临�Ӷ� O��n��
     */
    public boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrom(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    /**
     * ����������̬�滮
     */
    public static String longestPalindrom_dp(String s) {
        int len = s.length();
        String res = "";
        boolean[] dp = new boolean[len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= i; j--) {
                dp[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[j - 1]);
                if (dp[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    /**
     * ����������չ����
     * ÿ��ѭ��ѡ��һ�����ģ�����������չ���ж������ַ��Ƿ����
     */
    public static String longestPalindrom3(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * ������
     */
    public String longestPalindrome4(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         ������ʼλ�ã��������������ƺ��ܱ�ȫ�ֱ����Կ�һ��
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             �ѻ��Ŀ����м�Ĳ���ȫ��ͬһ�ַ������Ҳ�����Գ�
//             �ҵ���һ���뵱ǰ�ַ���ͬ���ַ�
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         �����м䲿��
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         ��λ�м䲿�ֵ����һ���ַ�
        int ans = high;
//         ���м���������ɢ
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         ��¼��󳤶�
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

}
