package cc.liuyong.leetcode;

public class A39删除链表的倒数第N个节点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        ListNode l = pre, r = pre;
        while (n != 0) {
            l = l.next;
            n--;
        }

        while (l.next != null) {
            l = l.next;
            r = r.next;
        }
        r.next = r.next.next;
        return pre.next;
    }
}
