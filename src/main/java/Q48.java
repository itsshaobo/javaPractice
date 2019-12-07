public class Q48 {

    public int longestSubstring(String str) {
        /**
         * 状态设计 dp[i]表示以str[i]结尾的最大无重复字符串长度
         * 状态专业 dp[i] = 如果没有找到str[i] dp[i-1]+1
         *                 前一个str[i] 离本位置的距离为d 如果 d > dp[i-1] :dp[i-1]+1
         *                                                  d <= dp[i-1] :d
         * */
        char [] strList = str.toCharArray();
        int [] dp = new int[str.length()];
        dp[0] = 1;
        for(int i=1;i<str.length();i++){
            int j = i-1;
            while(j>-1 && strList[j]!=strList[i]){
                j--;
            }
            if(j==-1){
                dp[i] = dp[i-1] + 1;
            }else{
                int d = i-j;
                if(d > dp[i-1]){
                    dp[i] = dp[i-1] + 1;
                }else{
                    dp[i] = d;
                }
            }
        }
        int res = 0;
        for(int elem:dp){
            res = res>elem?res:elem;
        }
        return res;
    }

}
