package cc.liuyong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A12二叉树的锯齿形层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean flag = false;

        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode poll = queue.removeFirst();
                if (flag) {
                    list.addFirst(poll.val);
                } else {
                    list.addLast(poll.val);
                }
                if (poll.left != null) queue.addLast(poll.left);
                if (poll.right != null) queue.addLast(poll.right);
            }
            flag = !flag;
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
