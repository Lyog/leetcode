package cc.liuyong.leetcode;

public class A28最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int ans = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;

        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
