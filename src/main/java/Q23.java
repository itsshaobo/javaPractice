public class Q23 {

    public ListNode meetNode(ListNode head){
        //找到链表中环的入口
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && slow!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast==null || fast.next == null){
            return null;
        }
        fast =head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
