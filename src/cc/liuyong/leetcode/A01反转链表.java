package cc.liuyong.leetcode;

public class A01反转链表 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next  = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return  pre;
    }

    public ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
