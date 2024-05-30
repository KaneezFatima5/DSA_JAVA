package LinkedList;

public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        ListNode head=new ListNode(-1);
        ListNode newList=head;
        for(int k=0; k<lists.length;k++){
            if(lists[k]==null){
                continue;
            }
            while (lists[k]!=null && lists[k+1]!=null) {
                if(lists[k].val<lists[k+1].val){
                    newList.val=lists[k].val;
                    lists[k]=lists[k].next;
                }else{
                    newList.val=lists[k+1].val;
                    lists[k+1]=lists[k+1].next;
                }
                // if(lists[k]!=null && lists[k+1]!=null){
                    newList.next=new ListNode();
                    newList=newList.next;
                // }
            }
            while(lists[k]!=null){
                newList.val=lists[k].val;
                lists[k]=lists[k].next;
                if(lists[k]!=null){
                    newList.next=new ListNode();
                    newList=newList.next;
                }
            }
            while(lists[k+1]!=null){
                newList.val=lists[k+1].val;
                lists[k+1]=lists[k+1].next;
                if(lists[k+1]!=null){
                    newList.next=new ListNode();
                    newList=newList.next;
                }
            }
            lists[k+1]=head;
            head =new ListNode();
            newList=head;
        }
        return lists[lists.length-1];
    }
}
