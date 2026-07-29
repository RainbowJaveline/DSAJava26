class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long total = 0;
        // int[] nextGreater = nextGreaterElement(arr);
        // int[] nextSmaller = nextSmallerElement(arr);
        for(int i = 0 ; i<n ; i++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j=i ; j<n ; j++){
                max = Math.max(max , nums[j]);
                min = Math.min(min , nums[j]);
                int diff = max - min;
                total+=diff;
            }
        }
        return total;
    }
}