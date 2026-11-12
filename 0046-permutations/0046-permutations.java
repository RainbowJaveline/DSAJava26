class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        helper(answer , nums , new ArrayList<>() , freq);
        return answer;
    }

    public void helper(List<List<Integer>> answer , int[] nums , List<Integer> temp , boolean[] freq){
        if(temp.size() == nums.length){
            answer.add(new ArrayList<>(temp));
            return;
        }

        for(int i= 0 ; i<nums.length ; i++){
            if(!freq[i]){
                temp.add(nums[i]);
                freq[i] = true;
                helper(answer,nums,temp,freq);
                temp.removeLast();
                freq[i] = false;
            }
        }
    }
}