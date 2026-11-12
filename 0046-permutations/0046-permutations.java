class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        helper(answer , nums , 0);
        return answer;
    }

    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void helper(List<List<Integer>> answer , int[] nums ,int idx){
        if(idx == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i= 0 ; i<nums.length ; i++){
                ds.add(nums[i]);
            }
            answer.add(new ArrayList<>(ds));
            return;
        }

        for(int i= idx ; i<nums.length ; i++){
            swap(nums , idx , i);
            helper(answer , nums , idx+1);
            swap(nums , idx , i);
        }
    }
}