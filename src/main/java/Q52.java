import java.util.Stack;

public class Q52 {
    // 从后往前找，用2个栈储存中间的节点

    // 为 找到两课树的公共最近祖先提供了思路
    public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        if(head1==null || head2==null) return null;
        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();
        while(head1!=null){
            stack1.push(head1);
            head1 = head1.next;
        }
        while(head2!=null){
            stack2.push(head2);
            head2 = head2.next;
        }
        ListNode commonNode = null;
        while(stack1.peek()==stack2.peek()){
            commonNode = stack1.peek();
            stack1.pop();
            stack2.pop();
        }
        return commonNode;
    }

    public static void main(String [] args) {
        ListNode head1 = new ListNode(4);
        ListNode common = new ListNode(6);
        head1.next = new ListNode(5);
        head1.next.next = common;
        ListNode head2 = new ListNode(1);
        head2.next = common;
        Q52 test = new Q52();
        System.out.println(test.findFirstCommonNode(head1, head2).val);

    }
}
