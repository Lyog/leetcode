package cc.liuyong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A22全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int i : nums) {
            output.add(i);
        }
        func(output.size(), 0, ans, output);
        return ans;
    }

    public void func(int count, int first, List<List<Integer>> ans, List<Integer> output) {
        if (count == first) {
            ans.add(new ArrayList<>(output));
        }
        for (int i = first; i < count; i++) {
            Collections.swap(output, first, i);
            func(count, first + 1, ans, output);
            Collections.swap(output, first, i);
        }
    }
}
