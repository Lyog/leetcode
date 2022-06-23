package cc.liuyong.leetcode;

public class A15二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode leftChild = lowestCommonAncestor(root.left, p, q);
        TreeNode rightChild = lowestCommonAncestor(root.right, p, q);
        if (leftChild == null && rightChild == null) return null;
        if (leftChild != null && rightChild != null) return root;
        return leftChild == null?rightChild:leftChild;
    }
}
