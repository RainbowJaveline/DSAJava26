class Solution {
    public int climbStairs(int n) {
        // if(n == 1) return 1;
        // if(n == 2) return 2;

        // return climbStairs(n-1) + climbStairs(n-2);
        int[] memo = new int[n+1];
        return helper(n , memo);
    }
    public int helper(int n , int[] memo){
        if(n==1) return 1;
        if(n==2) return 2;

        if(memo[n] != 0){
            return memo[n];
        }

        memo[n] = helper(n-1 , memo) + helper(n-2 , memo);
        return memo[n];
    }
}