public class Q15 {

    public int Num1(int n){
        int count = 0;
        while(n!=0){
            if((n & 1) == 1){
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String [] args) {
        Q15 test = new Q15();
        System.out.println(test.Num1(-10));
    }
}
