package LinkedList;

public class AddNumbers {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            val=this.val;
        }
        ListNode(int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static void main(String[] args){

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1=l1;
        ListNode node2=l2;
        ListNode node3= new ListNode();
        while (node1!=null && node2!=null) {
            node3.val=node1.val+node2.val;
            System.out.print(node3.val);
            node3=node3.next;

            node1=node1.next;
            node2=node2.next;
        }
        if(node1!=null){
            node3.next=node1;
        }
        if(node2!=null){
            node3.next=node2;
        }
        return node3;
    }
}
