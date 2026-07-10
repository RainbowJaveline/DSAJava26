class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        //find the maximum element
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int ans = Integer.MAX_VALUE;
        //max will have the maximum value in the array
        //start with the low and high
        int low = 1;
        int high = max;
        while( low <= high ){
            int mid = (low + high)/2;
            int sum = sumOfDivisors(mid , nums);
            if(sum <= threshold){
                if( mid < ans){
                    ans = mid;
                }else{
                    high = mid - 1;
                }
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int sumOfDivisors(int n , int[] nums){
        int sum = 0;
        for(int i = 0 ; i<nums.length ; i++){
            long ceilingDivision = ((long) nums[i] + n - 1) / n;
            sum += (int) ceilingDivision;
        }
        return sum;
    }
}