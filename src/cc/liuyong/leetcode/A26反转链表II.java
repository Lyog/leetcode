package cc.liuyong.leetcode;

import java.util.List;

public class A26反转链表II {

//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        ListNode temp = new ListNode(-1, head);
//        ListNode pre = temp;
//        for (int i = 0; i < left - 1; i++) {
//            pre = pre.next;
//        }
//        ListNode cur = pre.next;
//        ListNode next;
//        for (int i = left; i < right; i++) {
//            next = cur.next;
//            cur.next = next.next;
//            next.next = pre.next;
//            pre.next = next;
//        }
//        return temp.next;
//    }

    ListNode temp = null;

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            temp = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = temp;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
