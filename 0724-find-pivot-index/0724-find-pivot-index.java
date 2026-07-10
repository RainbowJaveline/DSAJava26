class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        for(int ele : nums){
            rightSum+=ele;
        }
        int leftSum = 0;
        for(int i =0;i<nums.length;i++){
            //remove the element from the rightSum
            rightSum-=nums[i];
            //check if at some point boht left and right sum becomes equal
            if(leftSum == rightSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}