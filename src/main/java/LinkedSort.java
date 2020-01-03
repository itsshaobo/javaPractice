public class LinkedSort {

    public ListNode fastSort(ListNode head) {
        fastHelper(head, null);
        return head;
    }

    public void fastHelper(ListNode start, ListNode end) {
        if(start==null || start==end) return ;
        ListNode p = start;
        ListNode q = start.next;
        int key = start.val;
        while(q!=end) {
            if(q.val < key) {
                p = p.next;
                swap(p,q);
            }
            q = q.next;
        }
        swap(start, p);
        fastHelper(start, p);
        fastHelper(p.next, end);
    }

    private void swap(ListNode p, ListNode q) {
        int tmp = p.val;
        p.val = q.val;
        q.val = tmp;
    }

    public ListNode mergeSort(ListNode head){
        if(head==null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode leftPart = mergeSort(head);
        ListNode rightPart = mergeSort(fast);
        ListNode newHead = new ListNode(0);
        ListNode tmp = newHead;
        while(leftPart!=null && rightPart!=null) {
            if(leftPart.val < rightPart.val) {
                tmp.next = leftPart;
                leftPart = leftPart.next;
            }else{
                tmp.next = rightPart;
                rightPart = rightPart.next;
            }
            tmp = tmp.next;
        }
        while(leftPart!=null) {
            tmp.next = leftPart;
            tmp = tmp.next;
            leftPart = leftPart.next;
        }
        while(rightPart!=null) {
            tmp.next = rightPart;
            tmp = tmp.next;
            rightPart = rightPart.next;
        }
        return newHead.next;
    }
}
