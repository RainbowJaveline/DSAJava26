class Solution {
    public int sumOfUnique(int[] nums) {
        int max = 0;
        for(int num : nums){
            max = Math.max(max,num);
        }
        int[] freq = new int[max+1];
        for(int i=0 ; i<nums.length ; i++){
            freq[nums[i]]++;
        }
        int add = 0;
        for(int i=1; i<freq.length ; i++){
            if(freq[i] == 1){
                add += i;
            }
        }
        return add;
    }
}