package cc.liuyong.leetcode;

public class A33反序列化二叉树 {

    public TreeNode getTree(String[] strings, int index) {
        if (index >= strings.length) return null;
        String value = strings[index++];
        if (value.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = getTree(strings, index);
        node.right = getTree(strings, index);
        return node;
    }

    public TreeNode func(String str) {
        String[] split = str.split(",");
        int index = 0;
        return getTree(split, index);
    }

    public static void main(String[] args) {

    }

}
