public class Q46 {

    //将数字翻译成字符串
    public int countTransMethod(String num){
        /**
         * 状态设计： dp[i]表示当前右几种表示方法
         * 状态专业： dp[i] = dp[i-1] + (dp[i-2]仅当numChar[i-1]!=0而且numChar[i-1~i]<26)
         * 边界条件： dp[i]表示第i个数字， dp[0]起站位作用
         * */
        char[] numChar = num.toCharArray();
        int n = numChar.length;
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        int tmp = 0;
        for(int i=2;i<=n;i++){
            dp[i] += dp[i-1];
            tmp = 10 * Integer.valueOf(numChar[i-2]-'0');
            tmp += Integer.valueOf(numChar[i-1]-'0');
            if(tmp>=10 && tmp<=25){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String [] args) {
        Q46 test = new Q46();
        System.out.println(test.countTransMethod("12258"));
    }

}
