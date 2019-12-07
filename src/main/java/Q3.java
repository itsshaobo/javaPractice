public class Q3 {

    public int findDup(int [] nums) {
        // 遍历， 如果 i != nums[i]， 比较i 和 nums[nums[i]]如果相同则返回， 如果不同交换 nums[i]和nums[m],再进行比较
        // 时间复杂度 O(n)
        for(int i=0;i<nums.length;i++){
            int m = nums[i];
            if(m == i) continue;
            while(m!=i){
                System.out.printf("%d\t%d\n",m, nums[m]);
                if(m == nums[m]) return m;
                int tmp = nums[i];
                nums[i] = nums[m];
                nums[m] = tmp;
                m = nums[i];
            }
        }
        return -1;
    }

    public static void main(String [] args) {
        Q3 test = new Q3();
        System.out.println(test.findDup(new int[]{2,3,1,0,2,5,3}));

    }
}
