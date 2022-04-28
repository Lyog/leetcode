package cc.liuyong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A33反序列化二叉树 {

    public TreeNode getTree(String[] strings, int index) {
        if (index >= strings.length) return null;
        String value = strings[index];
        if (value.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = getTree(strings, index+1);
        node.right = getTree(strings, index+2);
        return node;
    }

    public TreeNode func(String str) {
        String[] split = str.split(",");
        int index = 0;
        return getTree(split, index);
    }

    public static void main(String[] args) {
        String str = "1,2,3,4,5,#";
        A33反序列化二叉树 a = new A33反序列化二叉树();
        List<Integer> res = new ArrayList<>();
        a.preOrder(a.func(str),res);
        System.out.println("");

    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        System.out.println(root.val);
//        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

}
