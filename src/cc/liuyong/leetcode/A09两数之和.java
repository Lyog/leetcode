package cc.liuyong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class A09两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - i)) {
                return new int[]{map.get(target - i), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
    }
}
