public class Q21 {

    public void recordOddEven(int [] num) {
        int n = num.length;
        int left = findNextEven(num, 0); //表示从左开始数第一个偶数的位置
        int right = findNextEven(num, n-1); //表示从右开始第一个奇数的位置
        while(left<right && left<n && right>=0){
            int tmp = num[left];
            num[left] = num[right];
            num[right] = tmp;
            left = findNextEven(num, left);
            right = findNextOdd(num, right);
        }
        for(int i:num) {
            System.out.printf("%d\t",i);
        }
    }

    public int findNextEven(int [] num, int pos){
        //偶数从左向右找
        int n = num.length;
        while(pos<n && (num[pos]&1)==1){
            pos++;
        }
        return pos;
    }

    public int findNextOdd(int [] num, int pos){
        //奇数从右向左找
        while(pos>=0 && (num[pos]&1)!=1){
            pos--;
        }
        return pos;
    }

    public static void main(String [] args) {
        Q21 test = new Q21();
        test.recordOddEven(new int []{2,1,4,5,7,8});
    }
}
