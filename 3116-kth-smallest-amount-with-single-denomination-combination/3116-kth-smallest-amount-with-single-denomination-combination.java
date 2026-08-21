class Solution {

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b, long limit) {
        long g = gcd(a, b);
        a /= g;

        // Prevent overflow and ignore LCMs larger than limit.
        if (a > limit / b) {
            return limit + 1;
        }

        return a * b;
    }

    private long count(long x, int[] coins) {
        int n = coins.length;
        long result = 0;

        // Inclusion-exclusion over all non-empty subsets.
        for (int mask = 1; mask < (1 << n); mask++) {
            long currentLcm = 1;
            int bits = 0;
            boolean tooLarge = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    currentLcm = lcm(currentLcm, coins[i], x);

                    if (currentLcm > x) {
                        tooLarge = true;
                        break;
                    }
                }
            }

            if (tooLarge) {
                continue;
            }

            long contribution = x / currentLcm;

            if ((bits & 1) == 1) {
                result += contribution;
            } else {
                result -= contribution;
            }
        }

        return result;
    }

    public long findKthSmallest(int[] coins, int k) {
        long minCoin = Integer.MAX_VALUE;

        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        long low = 1;
        long high = minCoin * (long) k;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}