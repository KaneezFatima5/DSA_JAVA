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
        ListNode head=new ListNode();
        ListNode node=head;
        int rem=0;
        while(l1!=null && l2!=null){
            int add = (l1.val+l2.val+rem);
            node.val=add%10;
            l1=l1.next;
            l2=l2.next;
            rem=add/10;
            if(l1!=null || l2!=null){
                node.next=new ListNode();
                node=node.next;
            }
            System.out.print(rem);
        }
        while(l1!=null){
            node.val=(l1.val+rem)%10;
            rem=(l1.val+rem)/10;
            l1=l1.next;
            if(l1!=null){
                node.next=new ListNode();
                node=node.next;
            }
        }
        while(l2!=null){
            node.val=(l2.val+rem)%10;
            rem=(l2.val+rem)/10;
            l2=l2.next;
            if(l2!=null){
                node.next=new ListNode();
                node=node.next;
            }
        }
        if(rem>0){
            node.next=new ListNode();
            node=node.next;
            node.val=rem;
        }
        return head;
    }
    // ListNode node1=l1;
    //     ListNode node2=l2;
    //     ListNode l3 = new ListNode(-1);
    //     ListNode node3=l3;
    //     int rem=0;
    //     while (node1!=null && node2!=null) {
    //         node3.next=new ListNode();
    //         node3=node3.next;
    //         node3.val=(node1.val+node2.val+rem)%10;
    //         System.out.print(l3.val);
    //         if((node1.val+node2.val+rem)>9){
    //             rem=1;
    //         }else{
    //             rem=0;
    //         }

    //         node1=node1.next;
    //         node2=node2.next;
    //     }
    //     while(node1!=null){
    //         node3.next=new ListNode();
    //         node3=node3.next;
    //         node3.val=(node1.val+rem)%10;
    //         if((node1.val+rem)>9){
    //             rem=1;
    //         }else{
    //             rem=0;
    //         }
    //         node1=node1.next;
    //     }
    //     while(node2!=null){
    //         node3.next=new ListNode();
    //         node3=node3.next;
    //         node3.val=(node2.val+rem)%10;
    //         if((node2.val+rem)>9){
    //             rem=1;
    //         }else{
    //             rem=0;
    //         }
    //         node2=node2.next;
    //     }
    //     if(rem>0){
    //         node3.next=new ListNode();
    //         node3=node3.next;
    //         node3.val=rem;
    //     }
    //     System.out.print(l3.val);
    //     return l3.next;
}
