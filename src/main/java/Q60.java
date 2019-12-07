public class Q60 {

    /**
     * n个筛子仍在地上，所有筛子朝上一面的点数之和为s，输入n打印s所有可能的概率
     *
     * */
    // TODO 动态规划算法
    public void printProba(int n) {
        /**
         * 状态设计： dp[i][j]表示共有i个筛子， 点数和为j的出现次数
         * 状态转移： dp[i][j] = dp[i-1][j-1] + dp[i-1][j-2]
         * 边界条件： dp[1][1~6] = 1
         * */
        int [][] dp = new int[n+1][6*n+1];
        for(int i=1;i<=6;i++){
            dp[1][i] = 1;
        }
        for(int i=2;i<=n;i++) {
            for(int j=i;j<=6*i;j++) {
                for(int k=1;k<=6;k++) {
                    if(j-k>0) dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        for(int j=n;j<=6*n;j++) {
            System.out.printf("%d\t", dp[n][j]);
        }

    }

    public static void main(String [] args) {
        Q60 test = new Q60();
        test.printProba(3);
    }
}
