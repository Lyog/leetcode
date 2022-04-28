package cc.liuyong.leetcode;

import java.util.HashSet;
import java.util.Set;

public class A02无重复最长子串 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new A02无重复最长子串().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int right = -1;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (i != 0) set.remove(s.charAt(i - 1));
            while (right + 1 < len && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(++right));
            }
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }
}
