class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
            int[] leftSum = new int[n];
            int[] rightSum = new int[n];
            int lsum = 0;
            for(int i=0;i<n;i++){
                lsum+=nums[i];
                leftSum[i] = lsum;
            }
            int rsum = 0;
            for(int j=n-1;j>=0;j--){
                rsum+=nums[j];
                rightSum[j] = rsum;
            }
            for(int k=0;k<n;k++){
                if(leftSum[k] == rightSum[k]){
                    return k;
                }
            }
            return -1;
    }
}