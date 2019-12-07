import java.util.Stack;

public class StackWithMin<T extends Comparable<T>> {

    private Stack<T> stack;
    private Stack<T> minVal;

    public StackWithMin(){
        stack = new Stack<T>();
        minVal = new Stack<T>();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int size(){
        return stack.size();
    }


    public void push(T elem) {
        stack.push(elem);
        if(minVal.isEmpty() || minVal.peek().compareTo(elem)>=0){
            minVal.push(elem);
        }
    }

    public T pop() throws Exception {
        if(stack.isEmpty()){
            throw new Exception("stack is empty");
        }
        T tmp = stack.pop();
        if(tmp.equals(minVal.peek())){
            minVal.pop();
        }
        return tmp;
    }

    public T min() throws Exception {
        if(stack.isEmpty()){
            throw new Exception("stack is empty");
        }
        return minVal.peek();
    }


//    public static void main(String [] args) {
//        StackWithMin<Integer> test = new StackWithMin<Integer>();
//        test.push(1);
//        test.push(4);
//        test.push(2);
//        try{
//            System.out.println(test.min());
//            System.out.println(test.pop());
//            System.out.println(test.min());
//            test.push(-100);
//            System.out.println(test.min());
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
}
