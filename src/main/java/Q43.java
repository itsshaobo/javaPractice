public class Q43 {

    public int NumberOf1(int n) {
        if(n<=0) return 0;
        int count = 0;
        int length = String.valueOf(n).length();
        int first = n / (int)Math.pow(10, length-1); //表示最高位数
        int last =  n % (int)Math.pow(10, length-1); //除去最高位数
        if(first==1){
            count +=  last + 1;
        }else{
            count += (int)Math.pow(10, length-1);
        }
        if(n>=2){
            count += (length-1) * first * (int)Math.pow(10, length-2);
        }
        if(last > 0){
            count = count + NumberOf1(last);
        }
        return count;
    }

    public static void main(String [] args) {
        Q43 test = new Q43();
        System.out.println(test.NumberOf1(11));
    }
}
