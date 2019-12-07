import java.util.Comparator;
import java.util.PriorityQueue;

public class Q41 {
    //heap的初始为小顶堆
    private PriorityQueue<Integer> bigHeap;
    private PriorityQueue<Integer> smallHeap;

    public Q41(){
        bigHeap = new PriorityQueue<Integer>((n1,n2)->n2-n1);
        smallHeap = new PriorityQueue<Integer>();
    }

    public float findMid(){
        if(bigHeap.size()!=0){
            if(bigHeap.size() == smallHeap.size()){
                return (float)(bigHeap.peek()+smallHeap.peek()) / 2;
            }else{
                return bigHeap.peek();
            }
        }
        return -1;
    }

    public void put(int num) {
        // 加入元素
        if(bigHeap.isEmpty()){
            bigHeap.offer(num);
        }else if(smallHeap.isEmpty()){
            smallHeap.offer(num);
        }else if (num>=smallHeap.peek()){
            smallHeap.offer(num);
        }else{
            bigHeap.offer(num);
        }
        // 调整位置
        if(smallHeap.size() > bigHeap.size()){
            bigHeap.offer(smallHeap.poll());
        }else if(bigHeap.size() - smallHeap.size() > 1){
            smallHeap.offer(bigHeap.poll());
        }
    }

    public static void main(String [] args) {
        int [] a = {1,4,2,6,10,7,3};
        Q41 test = new Q41();
        for(int elem:a){
            test.put(elem);
            System.out.println(test.findMid());
        }
    }
}
