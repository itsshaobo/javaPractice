public class Q6 {

    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode p = head.next;
        head.next = null;
        while(p!=null){
            ListNode tmp = p;
            p = p.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}
