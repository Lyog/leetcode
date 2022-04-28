package cc.liuyong.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class A14有效的括号 {

    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (list.isEmpty() || !list.getLast().equals(map.get(ch))) {
                    return false;
                }
                list.removeLast();
            } else {
                list.addLast(ch);
            }
        }
        return list.isEmpty();
    }
}
