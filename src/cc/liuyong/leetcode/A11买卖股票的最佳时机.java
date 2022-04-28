package cc.liuyong.leetcode;

public class A11买卖股票的最佳时机 {

    public int maxProfit(int prices[]) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > ans) {
                ans = price - min;
            }
        }
        return ans;
    }
}
