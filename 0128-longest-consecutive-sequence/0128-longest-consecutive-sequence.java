class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0) return 0;
        int currCount = 1;
        int longest = 1;
        int lastSmallest = nums[0];
        for(int i = 1 ; i< nums.length ; i++){
            if(nums[i] - 1 == lastSmallest){
                currCount++;
                lastSmallest = nums[i];
            }else if(nums[i] != lastSmallest){
                currCount = 1;
                lastSmallest = nums[i];
            }

            longest = Math.max(currCount , longest);
        }
        return longest ;       
    }
}