public class Q39 {

    // 在数组中出现的超过一半的数字
    public int moreThanHalfNum(int [] nums) {
        /**
         * 类似于快排的解法
         *
         * */
        int[] res = new int[]{-1};
        partition(nums, 0, nums.length-1, res);

        // 需要再检查数组中是否存在长度超过一半的元素
        int number = res[0];
        int count = 0;
        for(int elem:nums){
            if(elem==number) count++;
        }
        return count>nums.length/2?number:-1;
    }

    public void partition(int[] nums, int left, int right, int[] res){
        int i = left, j = right;
        while(i<j) {
            while (nums[i] <= nums[j] && j > i) {
                j--;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            while (nums[i] <= nums[j] && j > i) {
                i++;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        if(i==nums.length/2){
            res[0] =  nums[i];
            return ;
        }else if(left<i-1 && i>nums.length/2){
            partition(nums,left,i-1, res);
        }else if(i+1<right && i<nums.length/2){
            partition(nums,i+1, right, res);
        }
    }

    public static void main(String [] args) {
        Q39 test = new Q39();
        int [] a = {1,2,3,4,5};
        System.out.println(test.moreThanHalfNum(a));
    }
}
