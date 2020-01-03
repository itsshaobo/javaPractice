public class KMP {

    public int[] genPnext(String target) {
        int m = target.length();
        int [] pnext = new int [m];
        pnext[0] = -1;
        int k = -1, i = 0;
        while(i<m-1) {
            if(k==-1 || target.charAt(k)==target.charAt(i)) {
                i++;
                k++;
                pnext[i] = pnext[k];
            }else{
                k = pnext[k];
            }
        }
        return pnext;
    }

    public int kmp(String target, String pattern) {
        int [] pnext = genPnext(pattern);
        int i = 0, j = 0;
        int m = target.length(), n = pattern.length();
        while(i<m) {
            if(j==-1 || target.charAt(i)==pattern.charAt(j)) {
                i++;
                j++;
                if(j==n){
                    return i-j;
                }
            }else{
                j = pnext[j];
            }
        }
        return -1;
    }

    public static void main(String [] args) {
        KMP test = new KMP();
        System.out.println(test.kmp("shaoboisagoodperson","bad"));
    }
}
