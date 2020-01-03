package Tmp;

import java.util.Stack;

public class Tmp31 {

    public static boolean stackSeq(int [] pushed, int [] poped) {
        int n = pushed.length;
        int i=0, j=0;
        Stack<Integer> stack = new Stack<>();
        while(i<n) {
            stack.push(pushed[i]);
            i++;
            while(!stack.isEmpty() && j < n &&stack.peek() == poped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == n && stack.isEmpty();
    }
}
