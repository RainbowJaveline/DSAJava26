class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length ; i++){
            list.add(nums[i]);
            largest = Math.max(largest,nums[i]);
            smallest = Math.min(smallest,nums[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=smallest ; i<= largest ; i++){
            if(!list.contains(i)){
                ans.add(i);
            }
        }

        return ans;
    }
}