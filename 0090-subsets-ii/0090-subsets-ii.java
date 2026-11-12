class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        subsetsRecursion(nums , new ArrayList<>() , answer , 0);
        return answer;
    }

    public void subsetsRecursion(int[] nums , List<Integer> temp , List<List<Integer>> answer , int idx){
        if(idx ==  nums.length){
            answer.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);
        subsetsRecursion(nums , temp , answer , idx+1);
        temp.removeLast();
        int idx2 = idx+1;
        while(idx2<nums.length && nums[idx] == nums[idx2]){
            idx2++;
        }
        subsetsRecursion(nums , temp , answer , idx2);
        
    }
}