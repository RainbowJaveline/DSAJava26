class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }int add = 0;
        for(int i= 0 ; i<nums.length ; i++){
            if(map.get(nums[i]) == 1){
                add += nums[i];
            }
        }
        return add;
    }
}