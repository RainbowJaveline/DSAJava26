class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(answer , temp , candidates , 0 , 0 , target);
        return answer;
    }

    void helper(List<List<Integer>> answer , List<Integer> temp , int[] candidates , int idx , int sum , int target){

        if(idx == candidates.length || target < 0){
            if(sum == target){
                answer.add(new ArrayList<>(temp));
            }
            return;
        }

        // temp.add(arr[idx]);
        // //Single Take
        // helper(answer , temp , candidates , idx+1 , target - arr[idx]);
        // //Multiple take
        // helper(answer , temp , candidates , idx , target - arr[idx]);
        // temp.removeLast();
        // helper(answer , temp , candidates , idx+1 , target);
        //Not take
        helper(answer , temp , candidates , idx+1 , sum , target);
        if(sum + candidates[idx] <= target){
            //take
            temp.add(candidates[idx]);
            //keep taking the same idx
            helper(answer , temp , candidates , idx , sum+candidates[idx] , target);
            //ignore the idx 
            temp.removeLast();
            sum -= candidates[idx];
        }
    return ;
    }
}