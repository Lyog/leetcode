package cc.liuyong.leetcode;

public class A35二叉树的最大路径和 {
    private Integer pathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return pathSum;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        int sum = Math.max(root.val, root.val + Math.max(left, right));
        pathSum = Math.max(pathSum, Math.max(sum, root.val + left + right));
        return sum;
    }
}
