class Solution {
    public int maxAbsoluteSum(int[] nums) {
       int maxSum = nums[0];
       int minSum = nums[0];
       int res = nums[0];
       for(int i = 1 ; i<nums.length ; i++){
        maxSum = Math.max(nums[i] , nums[i] + maxSum);
        minSum = Math.min(nums[i] , nums[i] + minSum);
        res = Math.max(res , Math.max(Math.abs(maxSum),Math.abs(minSum)));
       }
       return Math.abs(res) ; 
    }
}