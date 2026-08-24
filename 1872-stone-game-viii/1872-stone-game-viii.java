class Solution {
    public int stoneGameVIII(int[] stones) {
         int n = stones.length;

        long[] prefix = new long[n];

        prefix[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        // If Alice takes all stones, the score difference is prefix[n - 1]
        long dp = prefix[n - 1];

        // Try every possible first merge.
        // We need at least 2 stones, so i starts from n - 2.
        for (int i = n - 2; i >= 1; i--) {
            dp = Math.max(dp, prefix[i] - dp);
        }

        return (int) dp;
    }
}