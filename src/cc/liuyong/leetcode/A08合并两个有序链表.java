package cc.liuyong.leetcode;

public class A08合并两个有序链表 {

    public ListNode mergeList(ListNode a,ListNode b){
        if (a == null) return b;
        if (b == null) return a;
        if (a.value<b.value){
            a.next = mergeList(a.next,b);
            return a;
        } else {
            b.next = mergeList(a,b.next);
            return b;
        }
    }

    public static void main(String[] args) {
    }
}
