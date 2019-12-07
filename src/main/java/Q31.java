import java.util.Stack;

public class Q31 {

    // 判断是否是出栈的顺序, 还是考察什么时候入栈， 什么时候出栈
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0, j = 0;
        int n = pushed.length;
        while(i<n){
            stack.push(pushed[i]);
            i++;
            while(!stack.isEmpty() && stack.peek() == popped[j] && j<n) {
                stack.pop();
                j++;
            }

        }
        return stack.isEmpty();
    }

    public static void main(String [] args) {
        Q31 test = new Q31();
        System.out.println(test.validateStackSequences(new int[]{2,1,0},new int[]{1,2,0}));
    }

}
