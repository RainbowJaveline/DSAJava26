class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int ele : nums){
            max = Math.max(max , ele);
            min = Math.min(min , ele);
        }
        //GCD of those two numbers
        int ans = 0;
        for(int i = 1 ; i<=max ; i++){
            if(max%i == 0 && min%i == 0){
                ans = i;
            }
        }
        return ans;
    }
}