package Tmp;

public class Tmp48 {

    public static int longestSubstring(String str) {
        int n = str.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1;i<n;i++) {
            int j = i-1;
            while(j>=0 && str.charAt(j)!= str.charAt(i)) {
                j--;
            }
            if(j<0) {
                dp[i] = dp[i-1] + 1;
            }else if(dp[i-1] >= i-j) {
                dp[i] = i-j;
            }else{
                dp[i] = dp[i-1] + 1;
            }
        }
        return dp[n-1];
    }
}
