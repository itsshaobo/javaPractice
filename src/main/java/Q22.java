public class Q22 {

    public ListNode lastKNode(ListNode head, int k) {
        // 第一个指针先移动k步， 之后第二个指针开始移动， 指到第一个指针移动到末尾
        ListNode q = head;
        for(int i=0;i<k;i++){
            if(q!=null) q=q.next;
            else{
                return null;
            }
        }
        ListNode p = head;
        while(q!=null){
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
