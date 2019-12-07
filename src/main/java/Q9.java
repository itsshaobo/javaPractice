import java.util.Stack;

public class Q9<T> {
    // 两个栈实现队列
    Stack<T> stack1 = new Stack<T>();
    Stack<T> stack2 = new Stack<T>();


    public int size(){
        return stack1.size() + stack2.size();
    }

    public boolean isEmpty(){
        return size() > 0;
    }

    public void offer(T elem){
        // offer操作 放入stack1
        stack1.push(elem);
    }

    public T poll(){
        //poll操作如果stack2有数， 从stack中取， 没有数
        try{
            if(!stack2.isEmpty()){
                return stack2.pop();
            }else{
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public T peek(){
        try{
            if(!stack2.isEmpty()){
                return stack2.peek();
            }else{
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.peek();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
