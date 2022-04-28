package cc.liuyong.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class A33反序列化二叉树 {

    public TreeNode deserialize(LinkedList<String> dataList) {
        if (dataList.isEmpty()) return null;
        String s = dataList.removeFirst();
        if (s.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(dataList);
        root.right = deserialize(dataList);
        return root;
    }

    public TreeNode func(String str) {
        String[] split = str.split(",");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(split));
        return deserialize(list);
    }

    public static void main(String[] args) {
        String str = "1,2,3,#,#,4,5,#,#";
        A33反序列化二叉树 a = new A33反序列化二叉树();
        a.func(str);
        a.preOrder(a.func(str));
        System.out.println("");

    }

    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

}
