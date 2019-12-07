public class Q40 {

    public void topK(int [] nums, int K) {
        //打印数组的topK小元素
        fastTopK(nums, 0, nums.length-1, K);
        for(int i=0;i<K;i++){
            System.out.printf("%d\t",nums[i]);
        }
        System.out.println();
    }

    public void fastTopK(int [] nums, int left, int right, int K) {
        int i = left, j = right;
        while(i<j){
            while(nums[i]<=nums[j] && i<j) j--;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            while(nums[i]<=nums[j]&& i<j) i++;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        if(left<i-1){
            fastTopK(nums, left, i-1, K);
        }
        if(i+1<right && i+1<=K-1){
            fastTopK(nums, i+1, right, K);
        }
    }

    public static void main(String [] args) {
        Q40 test = new Q40();
        int [] a = {1,2,6,6,5};
        test.topK(a, 3);
    }
}
