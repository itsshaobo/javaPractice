public class MergeSort {

    public static void mergeSort(int [] nums) {
        mergeHelper(nums, new int[nums.length], 0, nums.length-1);
    }

    private static void mergeHelper(int [] nums,int [] exchange, int left, int right) {
        if(left==right) return ;
        int mid = left + (right - left) / 2;
        mergeHelper(nums, exchange,left, mid);
        mergeHelper(nums, exchange, mid+1, right);
        int i=left, j = mid + 1, k = left;
        while(i<=mid && j <=right) {
            if(nums[i]>nums[j]){
                exchange[k] = nums[j];
                j++;
            }else{
                exchange[k] = nums[i];
                i++;
            }
            k++;
        }
        while(i<=mid){
            exchange[k] = nums[i];
            k++;
            i++;
        }
        while(j<=right) {
            exchange[k] = nums[j];
            k++;
            j++;
        }
        for(int l=left;l<=right;l++) {
            nums[l] = exchange[l];
        }
    }

    public static void main(String [] args) {
        int [] a = {1,4,3,9,10,-1};
        mergeSort(a);
        for(int i:a) {
            System.out.println(i);
        }
    }
}
