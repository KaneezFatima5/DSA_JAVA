package LinkedList;

import java.util.HashMap;

import LinkedList.AddNumbers.ListNode;

public class IntersectionOfLinkedList {
    public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
                next = null;
            }
        }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map=new HashMap<>();
        while(headA!=null){
            map.put(headA, headA.val);
            headA=headA.next;
        }
        while (headB!=null) {
            if(map.containsKey(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return 0;

    }
}
