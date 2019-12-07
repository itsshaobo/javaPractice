public class Q49 {

    public int getUglyNumber(int pos) {
        int [] ugly = new int[pos+1];
        int pos2 = 0, pos3 = 0, pos5 = 0;
        ugly[0] = 1;
        for(int i=1;i<=pos;i++) {
            int tmp = Math.min(ugly[pos2]*2, ugly[pos3]*3);
            tmp = Math.min(ugly[pos5]*5, tmp);
            ugly[i] = tmp;
            if(ugly[pos2]*2==tmp) pos2++;
            if(ugly[pos3]*3==tmp) pos3++;
            if(ugly[pos5]*5==tmp) pos5++;
        }
        return ugly[pos];
    }


}
