class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       int ans = 0;
       int curAns = 0;
       for(int i=0;i<nums.length;i++){
        if(nums[i] == 1){
            curAns++;
            ans = Integer.max(curAns , ans);
        }else{
            curAns = 0;
        }

       }
       return ans ;
    }
}