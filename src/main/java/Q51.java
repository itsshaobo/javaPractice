import java.util.ArrayList;
import java.util.List;

public class Q51 {
    List<int[]> res = new ArrayList<>();
    public List<int[]> inversePairs(int [] nums) {
        if(nums==null || nums.length<2) return null;
        int [] tmp = new int[nums.length];
        mergeHelper(nums, tmp, 0, nums.length, nums.length/2);
        return res;
    }

    public void mergeSort(int [] nums) {
        int [] tmp = new int[nums.length];
        mergeHelper(nums, tmp, 0, nums.length, nums.length/2);
    }

    public void mergeHelper(int [] nums, int [] tmp, int left, int right, int mid) {
        //[left,mid) [mid,right) 左闭右开区间
        // 从小到大排序
        if(left == mid || mid == right) return;
        mergeHelper(nums, tmp, left, mid, left+(mid-left)/2);
        mergeHelper(nums, tmp, mid, right, mid+(right-mid)/2);
        //此时[left,mid) [mid,right)已经是排好序的两段
        int i=left, j = mid;
        while(i<mid && j<right){
            while(j<right && nums[i]>nums[j]){
                j++;
            }
            for(int g=mid;g<j;g++) res.add(new int[]{nums[i],nums[g]});
            i++;
        }
        i = left;
        j= mid;
        int k = left;
        while(i<mid && j<right) {
            if(nums[i]>=nums[j]){
                tmp[k] = nums[j];
                j++;
            }else{
                tmp[k] = nums[i];
                i++;
            }
            k++;
        }
        while(i<mid){
            tmp[k] = nums[i];
            i++;
            k++;
        }
        while(j<right){
            tmp[k] = nums[j];
            j++;
            k++;
        }
        for(k=left;k<right;k++){
            nums[k] = tmp[k];
        }
    }

    public static void main(String [] args) {
        Q51 test = new Q51();
        int [] a = {5,2,10,-1,5,4,2};
        List<int[]> ans = test.inversePairs(a);
        for(int [] elem:ans){
            for(int i:elem){
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }

    }
}
