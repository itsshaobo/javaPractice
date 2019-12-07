import java.util.Arrays;
import java.util.Comparator;

public class Q45 {

    // 把数组排列成最小的数
    public String sortToMin(int [] nums) {
        //自定义比较方式， 之后放入sort中排序
        // 比较方式为 mn > nm mn表示字符串的拼接
        String [] numsStr = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr, new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                return (str1+str2).compareTo(str2+str1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String elem:numsStr){
            sb.append(elem);
        }
        return sb.toString();
    }

    public static void main(String [] args) {
        Q45 test = new Q45();
        System.out.println(test.sortToMin(new int[]{3,32,321}));
    }
}
