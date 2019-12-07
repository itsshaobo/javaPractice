public class Q53 {

    public int getKNum(int [] nums, int k) {
        //二分查找，找到第一个数和最后一个数
        // step1 查第一次出现的位置
        int left = 0, right = nums.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid] < k) left = mid+1;
            else right = mid;
        }
        int first = left;
        if(nums[first]!=k) return 0; // 此时查到的可能是大于k的第一个数， 也可能是小于k的最后一个数，也可能是k
        // step2 查第二次出现的位置
        left = 0;
        right = nums.length - 1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<=k) left = mid + 1;
            else right = mid;
        }
        int second = right; // second 代表的数>=key,要做一个判断
        if(nums[second]>k) second--;
        return second - first + 1;
    }

    public static void main(String [] args) {
        Q53 test = new Q53();
        //System.out.println(test.getKNum(new int[]{1,2,4,5},5));
        System.out.println(test.findLeak(new int[]{0,1,2,4,5}));

    }


    public int findLeak(int [] nums) {

        // 0~n-1这n个数中， 缺失了一个数， 保存在长度为n-1的数组中， 找出这个数
        // 前半部分 i==nums[i] 后半部分 nums[i+1] == i
        int left = 0, right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid] == mid) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
