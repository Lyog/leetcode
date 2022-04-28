package cc.liuyong.leetcode;

public class A24合并K个排序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] list, int low, int high) {
        if (low == high) return list[low];
        int mid = (low + high) / 2;
        ListNode l1 = merge(list, low, mid);
        ListNode l2 = merge(list, mid + 1, high);
        return merge2List(l1, l2);
    }

    public ListNode merge2List(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.value < b.value) {
            a.next = merge2List(a.next, b);
            return a;
        } else {
            b.next = merge2List(a, b.next);
            return b;
        }
    }
}
