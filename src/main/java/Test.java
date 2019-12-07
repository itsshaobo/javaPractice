public class Test {

    public static int one(int [] nums, int k) {
        // 查找第一个key
        int left = 0, right = nums.length-1;
        while(left<right){
            int mid = left + (right - left)/2;
            if(nums[mid] < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static int two(int [] nums, int k) {
        // 查找第一个key
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(nums[mid] <= k) left = mid + 1;
            else right = mid-1;
        }
        return right;
    }

    public static void main(String [] args) {
        System.out.println(two(new int[]{1,2,3,3,3,3}, 3));
    }
}
