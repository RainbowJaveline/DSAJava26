class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int ans = 0;
        int i= 1;
        while(true){
            if(i % k == 0 && !set.contains(i)){
                ans = i;
                break;
            }
            i++;
        }
         
        return ans; 
    }
}