public class Q44 {

    public int digitAtIndex(int n){
        if(n<=10) return n-1;
        int posNum = 1;
        int tmp = posNum * getNTotal(posNum);
        while(n - tmp > 0){
            n = n - tmp;
            posNum++;
            tmp = posNum * getNTotal(posNum);
        }
        int cnt = (n-1) / posNum;
        cnt = (int)Math.pow(10, posNum-1) + cnt;
        int res = Integer.valueOf(String.valueOf(cnt).charAt((n-1) % posNum) - '0');
        return res;
    }

    public int getNTotal(int n){
        //返回一共有多少个n位数字
        if(n==1){
            return 10;
        }
        return (int)Math.pow(10, n) - (int)Math.pow(10, n-1);
    }

    public static void main(String [] args) {
        Q44 test =new Q44();
        System.out.println(test.digitAtIndex(1001));
    }
}
