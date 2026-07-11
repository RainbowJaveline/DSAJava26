class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find the maximum element
        int max = piles[0];
        for(int i = 1 ; i<piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        int ans = Integer.MAX_VALUE;
        //max will have the maximum value in the array
        //start with the low and high
        int low = 1;
        int high = max;
        while( low <= high ){
            int mid = low + (high-low)/2;
            long sum = sumOfDivisors(mid , piles);
            if(sum <= h){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static long sumOfDivisors(int n , int[] nums){
        long sum = 0;
        for(int i = 0 ; i<nums.length ; i++){
            long ceilingDivision = ((long) nums[i] + n - 1) / n;
            sum += ceilingDivision;
        }
        return sum;
    }
}