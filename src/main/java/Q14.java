public class Q14 {

    /**
     * 状态设计： k[m][n] n米长的绳子剪成m段后 的乘积
     * 状态转移： k[m][n] = max i* K[m-1][n-i] 1<=i<n
     * 边界条件： k[1][n] = n  k[m][n] = 0 (m>n)
     * */
    public int cutRope(int m, int n) {
        int [][] dp = new int[m+1][n+1];
        for(int j=0;j<n+1;j++){
            dp[1][j] = j;
        }
        for(int i=2;i<=m;i++){
            for(int j=2;j<=n;j++){
                for(int k=1;k<j;k++){
                    dp[i][j] = Math.max(dp[i][j], k*dp[i-1][j-k]);
                }
            }
        }
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                System.out.printf("%d\t",dp[i][j]);
            }
            System.out.println();
        }
        return dp[m][n];
    }

    public int cutRope2(int n){
        int [] dp = new int[n+1];
        // dp[i]表示切长度为i能切的最大值
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4;i<=n;i++){
            for(int k=1;k<i;k++){
                dp[i] = Math.max(dp[i], dp[k]*dp[i-k]);
            }
        }
        for(int i=0;i<=n;i++){
            System.out.printf("%d\t",dp[i]);
        }
        return dp[n];
    }

    /**
     * 贪婪算法， 尽可能的多剪长度为3的绳子，剩下长度为4时，时 剪成2*2
     * */
    public int cutRope3(int n){
        if(n<=1) return 0;
        if(n==2) return 1;
        if(n==3) return 2;
        int times = n / 3;
        if(n % 3 <= 1){
            times--;
        }
        n = n - 3 * times;
        return (int)Math.pow(3, times) * n;
    }

    public static void main(String [] args) {
        Q14 test = new Q14();
        //System.out.println(test.cutRope(3,8));
        System.out.println(test.cutRope3(5));

    }
}
