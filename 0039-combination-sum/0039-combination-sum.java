class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(answer , temp , candidates , 0 , 0 , target);
        return answer;
    }

    void helper(List<List<Integer>> answer , List<Integer> temp , int[] candidates , int idx , int sum , int target){

        if(idx == candidates.length){
            if(sum == target){
                answer.add(new ArrayList<>(temp));
            }
            return;
        }

        helper(answer , temp , candidates , idx+1 , sum , target);
        if(sum + candidates[idx] <= target){
            temp.add(candidates[idx]);
            helper(answer , temp , candidates , idx , sum+candidates[idx] , target);
            temp.removeLast();
            sum -= candidates[idx];
        }
    return ;
    }
}