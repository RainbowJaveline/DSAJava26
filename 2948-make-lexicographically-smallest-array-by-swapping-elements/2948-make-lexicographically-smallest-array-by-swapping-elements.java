import java.util.*;

class Pairs {
    int num;
    int ogidx;
    Pairs(int num, int ogidx) {
        this.num = num;
        this.ogidx = ogidx;
    }
}

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Pairs[] arr = new Pairs[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pairs(nums[i], i);
        }

        Arrays.sort(arr, (a, b) -> a.num - b.num);

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i].num;
        }

        int[] ans = new int[n];
        int start = 0;

        for (int i = 1; i <= n; i++) {
            // break condition: either a real gap, or we've hit the end of array
            if (i == n || Math.abs(arr[i].num - arr[i - 1].num) > limit) {
                int end = i - 1;

                // sort this group's pairs by original index
                Arrays.sort(arr, start, end + 1, Comparator.comparingInt(a -> a.ogidx));

                // assign smallest values to smallest original indices
                for (int k = start; k <= end; k++) {
                    ans[arr[k].ogidx] = temp[k];   // <-- fixed: use k, not k-start
                }

                start = i;
            }
        }

        return ans;
    }
}