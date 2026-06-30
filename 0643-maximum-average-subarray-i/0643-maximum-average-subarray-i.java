class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0.0;
        double ans = Integer.MIN_VALUE;
        int l =0;
        int sum = 0;
        for(int h = 0 ; h < nums.length ; h++){
            sum+=nums[h];
            if(h - l + 1 > k){
                sum -= nums[l];
                l++;
            }
            if(h - l + 1 == k){
                avg = (double) sum /(k);
                if(avg > ans) ans = avg;
            }
        }
        return ans;
    }
}