package utils;

import lib.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static ListNode fromString(String string) {
        if(string.startsWith("[") && string.endsWith("]")) {
            string = string.substring(1, string.length() - 1);
        }

        String[] arr = string.split(",");
        List<Integer> valList = new ArrayList<>();

        for(String str : arr) {
            if(str.isEmpty()) continue;
            valList.add(Integer.valueOf(str));
        }

        return fromIntList(valList);
    }

    public static ListNode fromIntList(final List<Integer> integerList) {
        if(integerList == null || integerList.size() == 0) return null;
        ListNode head = null;

        ListNode p = null;

        for (Integer val : integerList) {
           if(head == null) {
               head = new ListNode(val);
               p = head;
           } else {
               p.next = new ListNode(val);
               p = p.next;
           }
        }
        return head;
    }



}
