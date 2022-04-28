package cc.liuyong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A36二叉树的右视图 {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return list;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (list.size() == depth) {
            list.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
