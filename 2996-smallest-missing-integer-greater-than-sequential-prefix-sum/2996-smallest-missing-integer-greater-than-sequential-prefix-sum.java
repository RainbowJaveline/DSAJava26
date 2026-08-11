class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;

    int prefixSum = nums[0];
    int i = 1;

    // Find sequential prefix
    while (i < n && nums[i] == nums[i - 1] + 1) {
        prefixSum += nums[i];
        i++;
    }

    HashSet<Integer> set = new HashSet<>();

    for (int num : nums) {
        set.add(num);
    }

    // Find smallest missing integer >= prefixSum
    while (set.contains(prefixSum)) {
        prefixSum++;
    }

    return prefixSum;
    }
}