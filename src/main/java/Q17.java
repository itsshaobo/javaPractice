public class Q17 {
    //打印从1到最大的n位数
    public void printN(int n) throws Exception {
        //递归法
        if(n<=0) {
            throw new Exception("0 or minus is not allowed");
        }
        char [] numbers = new char[n];
        backTrack(numbers, 0, n);
    }

    public void backTrack(char [] numbers, int cur, int n) {
        if(cur==n){
            pt(numbers);
            return ;
        }
        for(int i=0;i<10;i++){
            numbers[cur] = (char)(i+48);
            backTrack(numbers, cur+1, n);
        }
    }

    public void pt(char [] numbers) {
        boolean flag = false;
        int n = numbers.length;
        for(int i=0;i<n;i++){
            if(!flag && numbers[i] != '0'){
                flag = true;
            }
            if(flag){
                System.out.print(numbers[i]);
                if(i==n-1) System.out.print("\t");
            }
        }
    }

    public static void main(String [] args) {
        try{
            Q17 test = new Q17();
            test.printN(2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
