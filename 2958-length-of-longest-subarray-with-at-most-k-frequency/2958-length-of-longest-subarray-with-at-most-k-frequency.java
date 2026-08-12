class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
       HashMap<Integer , Integer > map = new HashMap<>();
       int l = 0;
       int maxLen = 0;
       for(int i=0 ; i<nums.length ; i++){
            int n = nums[i];
            map.put(n , map.getOrDefault(n,0)+1);
            while(map.get(n) > k){
               map.put(nums[l] , map.get(nums[l])-1);
                l++;
                if(map.get(n) == 0){
                    map.remove(i);
                }
            }
            maxLen = Math.max(maxLen , i-l+1);
       } 
       return maxLen;
    }
}