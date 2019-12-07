public class Q42 {

    public int LargestSubArray(int [] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int [] dp = new int[n];
        dp[0] = Math.max(dp[0], nums[0]);
        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int elem:dp){
            max = Math.max(max, elem);
        }
        return max;
    }
}
