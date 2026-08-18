class Solution {
    public int largestInteger(int[] nums, int k) {
        int max = nums[0];
        for(int i = 1 ; i<nums.length ; i++){
            max = Math.max(nums[i] , max);
        }
        if(k == nums.length){
            return max;
        }
        
        HashMap<Integer , Integer > map = new HashMap<>();
        int missing = -1;
        int n = nums.length;
        for(int i=0 ; i<nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i],0)+1);
        }
        if(k == 1 ){
            for(int num : nums){
                if(map.get(num) == 1){
                    missing = Math.max(missing ,num);
                }
            }
        }
        if(k>1 && k<nums.length){
            if(map.get(nums[0]) == 1 && map.get(nums[n-1]) == 1){
                return Math.max(nums[0] , nums[n-1]);
            }else if(map.get(nums[0]) == 1){
                return nums[0];
            }else if(map.get(nums[n-1]) == 1){
                return nums[n-1];
            }else{
                return -1;
            }
        }

        return missing;
    }
}