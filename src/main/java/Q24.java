public class Q24 {

    public ListNode reverse(ListNode head) {
        //翻转链表
        if(head==null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        head.next = null;
        ListNode tmp = null;
        while(p!=null){
            tmp = p;
            p =p.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}
