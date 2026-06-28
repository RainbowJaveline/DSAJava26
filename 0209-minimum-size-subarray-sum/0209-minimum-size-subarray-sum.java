class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int l = 0;
       int h = 0;
       int len = Integer.MAX_VALUE;
       int sum = 0;
       int n = nums.length;
       while(h < n){
        sum += nums[h];
        while(sum >= target){
            int curLen = h - l + 1;
            len = Math.min(curLen , len);
            sum = sum - nums[l];
            l++;
        }
        h++;
       } 
       if(len == Integer.MAX_VALUE) return 0;
       return len;
    }
}