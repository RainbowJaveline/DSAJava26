class Solution {
    public int firstStableIndex(int[] nums, int k) {
        if(nums.length == 1) return 0;
        int maxi = Integer.MIN_VALUE;
        for(int i=0 ; i<nums.length; i++){
            maxi = Math.max(maxi , nums[i]);
            int mini = Integer.MAX_VALUE;
            for(int j= i; j<nums.length ; j++){
                if(i == nums.length-1){
                    mini = nums[j];
                    break;
                }
                mini = Math.min(mini , nums[j]);
            }
            if(maxi - mini <= k){
                return i;
            }
        }

        return -1;
    }
}