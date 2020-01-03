public class Q11 {


    public int findMin(int[] nums) {
        // 无重复元素的查找
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            // 必须用right来查
            if(nums[mid] < nums[right]) {
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return nums[left];
    }

    public int findMinDup(int[] nums) {
        // 有重复元素的查找
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]){
                right = mid;
            }else if(nums[mid] == nums[right]){
                right--;
            }else{
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
