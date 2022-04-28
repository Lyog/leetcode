package cc.liuyong.leetcode;

public class A29接雨水 {
    public int trap(int[] height) {
        int ans = 0;
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        for (int i = 1; i < len - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);

        }
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) ans += min - height[i];
        }
        return ans;
    }
}
