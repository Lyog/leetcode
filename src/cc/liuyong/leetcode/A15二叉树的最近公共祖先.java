package cc.liuyong.leetcode;

public class A15二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode leftChild = lowestCommonAncestor(root.left, p, q);
        TreeNode rightChild = lowestCommonAncestor(root.right, p, q);
        if (leftChild == null && rightChild == null) return null;
        if (leftChild == null) return rightChild;
        if (rightChild == null) return leftChild;
        return root;
    }
}
