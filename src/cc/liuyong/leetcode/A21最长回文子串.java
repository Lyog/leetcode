package cc.liuyong.leetcode;

public class A21最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int start = 0, end = 0, ans = 1, len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l) && ((r - l <= 2) || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > ans) {
                        ans = r - l + 1;
                        start = l;
                        end = r;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
