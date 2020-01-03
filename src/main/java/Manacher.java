public class Manacher {
    {
        System.out.println("shaobob");
    }

    public static int[] manacher(String str) {
        //最长回文字符串
        StringBuilder sb = new StringBuilder("#");
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            sb.append("#");
        }
        String newStr = sb.toString();
        int [] dp = new int[newStr.length()];
        int cen = 0;
        int mx = 0;
        for(int i=0;i<dp.length;i++) {
            if(mx>i) {
                if(dp[2*cen-i]<mx-i){
                    dp[i] = dp[2*cen-i];
                    continue;
                } else{
                    dp[i] = mx - i;
                }
            }
            while(i-dp[i]>=0 && i+dp[i]<dp.length && newStr.charAt(i-dp[i])==newStr.charAt(i+dp[i])) {
                dp[i]++;
            }
            if(dp[i]+i>mx){
                cen = i;
                mx = dp[i]+i;
            }
        }
        int [] res = new int[dp.length/2];
        for(int i=0;i<res.length;i++) {
            //System.out.println(dp[i]);
            res[i] = dp[2*i+1]-1;
        }
        return res;
    }

    public static void main(String [] args) {
        for(int i:manacher("aaaaaa")){
            System.out.println(i);
        }
        Manacher test = new Manacher();
    }
}
