class Solution {
    public int thirdMax(int[] nums) {
       int largest = Integer.MIN_VALUE;
       int secondLargest = Integer.MIN_VALUE;
       int thirdLargest = Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++){
        if(nums[i] > largest){
            secondLargest = largest;
            largest = nums[i];
        }else if(nums[i] > secondLargest && largest > nums[i]){
            secondLargest = nums[i];
        }
       }
       boolean thirdExists = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < secondLargest && nums[i] < largest){
                thirdLargest=Math.max(nums[i],thirdLargest);
                thirdExists = true;
            }
        }

        if(!thirdExists) return largest;
        return thirdLargest; 
    }
}