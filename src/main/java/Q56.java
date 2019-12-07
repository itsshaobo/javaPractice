import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *  //数组中数出现次数类题集合
 *
 * */


public class Q56 {

    public static boolean q1207(int [] nums) {
       //统计每个数字的出现次数，如果出现次数各不相同，返回true 否则返回false
        Map<Integer, Integer> map = new HashMap<>();
        for(int elem:nums) {
            map.put(elem, map.getOrDefault(elem,0)+1);
        }
        return map.size() == new HashSet<Integer>(map.values()).size();
    }

    public static int[] q260(int [] nums) {
        // 在数组中有两个只出现一次的数字，其他的数字都出现两遍
        int single = 0;
        for(int elem:nums) {
            single = single^elem;
        }
        int last = single & -single;
        int a = 0, b = 0;
        for(int elem:nums) {
            if((elem&last)==last) {
                a = a^elem;
            }else{
                b = b^elem;
            }
        }
        int [] res = {a, b};
        return res;
    }

    public static void printTotal(int num) {
       // 打印和为num的连续序
        int small = 1, large = 2;
        int tmpSum = small+large;
        while(small<=num/2){
            if(tmpSum<num) {
                large++;
                tmpSum += large;
            }else if(tmpSum==num) {
                System.out.printf("the first number is %d, the second number is %d\n",small, large);
                large++;
                tmpSum += large;
            }else{
                tmpSum -= small;
                small++;
            }
        }
    }

    public static void main(String [] args) {
        printTotal(15);
    }
}
