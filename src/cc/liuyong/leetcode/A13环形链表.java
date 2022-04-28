package cc.liuyong.leetcode;

import java.util.HashSet;
import java.util.Set;

public class A13环形链表 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (!set.add(head)) return true;
            head = head.next;
        }
        return false;
    }
}
