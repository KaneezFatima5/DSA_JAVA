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
        ListNode l3 = new ListNode(-1);
        ListNode node3=l3;
        int rem=0;
        while (node1!=null && node2!=null) {
            node3.next=new ListNode();
            node3=node3.next;
            node3.val=(node1.val+node2.val+rem)%10;
            System.out.print(l3.val);
            if((node1.val+node2.val+rem)>9){
                rem=1;
            }else{
                rem=0;
            }

            node1=node1.next;
            node2=node2.next;
        }
        while(node1!=null){
            node3.next=new ListNode();
            node3=node3.next;
            node3.val=(node1.val+rem)%10;
            if((node1.val+rem)>9){
                rem=1;
            }else{
                rem=0;
            }
            node1=node1.next;
        }
        while(node2!=null){
            node3.next=new ListNode();
            node3=node3.next;
            node3.val=(node2.val+rem)%10;
            if((node2.val+rem)>9){
                rem=1;
            }else{
                rem=0;
            }
            node2=node2.next;
        }
        if(rem>0){
            node3.next=new ListNode();
            node3=node3.next;
            node3.val=rem;
        }
        System.out.print(l3.val);
        return l3.next;
    }
}
