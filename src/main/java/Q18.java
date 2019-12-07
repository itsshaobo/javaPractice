public class Q18 {

    // 给定一个链表的头结点 和 某个节点的指针，删除该节点
    /**
     * 主要考察删除链表节点的两种方式
     * 1.找到要删除节点的前一个节点
     * 2.用该节点的下一节点的值替代该节点的值，删除该节点的下一个节点
     * */
    public void deleteNode(ListNode head, ListNode p) {
        if(p.next==null){
            if(head == p) {
                head = null;
                return;
            }
            else{
                ListNode visitor = head;
                while(visitor.next!=null && visitor.next!=p){
                    visitor = visitor.next;
                }
                visitor.next = p.next;
                return;
            }
        }else{
            p.val = p.next.val;
            p.next = p.next.next;
            return ;
        }
    }
}
