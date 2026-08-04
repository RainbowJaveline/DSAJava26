class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<nums.length ; i++){
            largest = Math.max(largest,nums[i]);
            smallest = Math.min(smallest,nums[i]);
        }
        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[largest+1];
        for(int i : nums){
            arr[i]++;
        }
        for(int i=smallest; i<= largest;i++){
           if(arr[i] == 0){
            ans.add(i);
           }
        }
        return ans;
    }
}