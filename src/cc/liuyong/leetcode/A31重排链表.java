package cc.liuyong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class A31重排链表 {

    public void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp!= null){
            list.add(temp);
            temp = temp.next;
        }

        int i = 0,j = list.size()-1;
        while (i<j){
            list.get(i++).next = list.get(j);
            if (i == j) break;
            list.get(j--).next = list.get(i);
        }
        list.get(i).next = null;
    }
}
