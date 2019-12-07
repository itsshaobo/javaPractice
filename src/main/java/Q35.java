import java.util.HashMap;
import java.util.Map;

public class Q35 {

    //复制一个复杂链表，
    public ComplexListNode copyComplexList(ComplexListNode head) {
        /**
         * 1.对于每一个接点，拷贝其本身和next  建立hash表，key 为原节点的hashCode value为新接点
         * 2.在拷贝sibling时，通过hash表查找到复制后的新节点
         * */
        Map<Integer, ComplexListNode> map = new HashMap<Integer, ComplexListNode>();
        ComplexListNode p = head;
        ComplexListNode cpHead = new ComplexListNode(0);
        ComplexListNode q = cpHead;
        while(p!=null){
            q.next = new ComplexListNode(p.val);
            map.put(p.hashCode(), q.next);
            p = p.next;
            q = q.next;
        }
        p = head;
        cpHead = cpHead.next;
        q = cpHead;
        while(p!=null){
            q.sibling = map.get(q.sibling.hashCode());
            p = p.next;
            q = q.next;
        }
        return cpHead;
    }

    public ComplexListNode copy2(ComplexListNode head) {
        /**
         * 时间复杂度O(n) 空间复杂度0(1)
         * 1.对于每一个接点， 将其复制后放入原节点的next， 新节点的next指向原节点的next
         * 2.新节点的sibling接点就是其 前一个节点的sibling指向的节点的后一个节点
         * 3.将新产生的节点拿出来
         * */
        if(head == null) return null;
        ComplexListNode p = head;
        ComplexListNode tmp;
        // step1
        while(p!=null){
            tmp = new ComplexListNode(p.val);
            tmp.next = p.next;
            p.next = tmp;
            p = tmp.next;
        }
        // step2
        p = head;
        while(p!=null){
            p.next.sibling = p.sibling.next;
            p = p.next.next;
        }
        // step3
        ComplexListNode cpHead = head.next;
        p = cpHead;
        while(p!=null && p.next!=null){
            p.next = p.next.next;
            p = p.next;
        }
        return cpHead;
    }
}
