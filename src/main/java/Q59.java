import java.util.Deque;
import java.util.LinkedList;

public class Q59 {

    //滑动窗口的最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        if(nums==null || nums.length<2) return nums;
        int n = nums.length;
        if(n<k) return null;
        int [] ans = new int[n-k+1];
        for(int i=0;i<k;i++){
            if(deque.isEmpty()) deque.addLast(i);
            else {
                while(!deque.isEmpty() && nums[deque.getLast()]<nums[i]){
                    //System.out.println(nums[deque.peekLast()]);
                    deque.removeLast();
                }
                deque.addLast(i);
            }
        }
        ans[0] = nums[deque.getFirst()];
        for(int i=k;i<n;i++){
            while(!deque.isEmpty() && nums[deque.getLast()]<nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if(deque.getFirst()<=i-k){
                deque.removeFirst();
            }
            ans[i-k+1] = nums[deque.getFirst()];
        }
        return ans;
    }

    public static void main(String [] args) {
        Q59 test = new Q59();
        int [] ans = test.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7},3);
        for(int i:ans){
            System.out.println(i);
        }
//        Deque<Integer> test = new LinkedList<Integer>();
//        test.addLast(1);
//        test.addLast(2);
//        System.out.println(test.getFirst());
    }
}
