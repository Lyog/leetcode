package cc.liuyong.leetcode;

import java.util.PriorityQueue;

public class A03数组中的第K个最大元素 {

    public static void main(String[] args) {
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int i = 0;
        for (; i < k; i++)
            queue.add(nums[i]);
        for (; i < nums.length; i++)
            if (queue.peek() < nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
        return queue.peek();
    }
}
