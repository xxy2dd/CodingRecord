package com.company.leetcode.dp;

/**
 * @author xxy
 * @date 2019/7/2
 * @description
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class longestPalindrome {
    public static void main(String[] args) {
        String s = "xvbbababd";
        String res = longestPalindrom3(s);
        System.out.println(res);
    }

    /**
     * 方法一：暴力解法
     * 时间复杂度 O（n^3）
     * 空间复杂度 O（n）
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
     * 方法二：动态规划
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
     * 方法三：扩展中心
     * 每次循环选择一个中心，进行左右扩展，判断左右字符是否相等
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
     * 方法四
     */
    public String longestPalindrome4(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

}
