class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
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
            List<Integer> ds = new ArrayList<>();
            for(int i=0 ; i<nums.length ; i++){
                ds.add(nums[i]);
            }
            if(!answer.contains(new ArrayList<>(ds))){
                answer.add(new ArrayList<>(ds));
            }
            return;
        }

        for(int i = idx ; i<nums.length ; i++){
            if(nums[i] != nums[idx] && idx != i){
                swap(nums , idx , i);
            }
            helper(answer , nums , idx+1);
            swap(nums , idx , i);
        }
    }
}