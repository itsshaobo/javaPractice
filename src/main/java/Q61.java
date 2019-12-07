import java.util.Arrays;

public class Q61 {

    // 给定一个5个元素的序列，判断它是不是顺子， 其中 0 可以是任何数

    public static boolean checkContinuous(int[] num) {
        /**
         * 先排序， 如果包含1个0 ，2个0 没有0的情况
         * */
        Arrays.sort(num);
        int numKings = 0;
        if(num[0]==0) numKings++;
        if(num[1]==0) numKings++;
        int tmp = num[numKings] - numKings; // tmp代表相对于下标的偏移量
        int i = numKings+1;
        while(i<5){
            if(num[i]-i==tmp){ //等于说明是连续的数字
                i++;
            } else if(numKings!=0 && num[i]-i>tmp){ // num[i]-i<tmp说明出现相等的数字
                tmp++; // 如果用0补足当前位置，偏移量要+1
                numKings--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String [] args) {
        System.out.println(checkContinuous(new int[]{0,0,3,6,7}));
    }
}
