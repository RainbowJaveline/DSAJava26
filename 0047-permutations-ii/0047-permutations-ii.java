class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        if(nums.length == 0 || nums == null){
            return answer;
        }
        helper(answer , nums , 0);
        return answer;
    }

    public void swap(int[] nums , int i , int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void helper(List<List<Integer>> answer , int[] nums , int idx){
        if(idx == nums.length){
            List<Integer> ds = new ArrayList<>(nums.length);
            for(int i=0 ; i<nums.length ; i++){
                ds.add(nums[i]);
            }
            answer.add(ds);
            return;
        }
        HashSet<Integer> placed = new HashSet<>();
        for(int i = idx ; i<nums.length ; i++){
            if(placed.contains(nums[i])){
                continue;
            }
            placed.add(nums[i]);
            swap(nums , idx , i);
            helper(answer , nums , idx+1);
            swap(nums , idx , i);
        }
    }
}