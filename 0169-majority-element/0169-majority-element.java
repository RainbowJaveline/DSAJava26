class Solution {
    public int majorityElement(int[] nums) {
      HashMap<Integer,Integer> map = new HashMap<>();
      int ans = 0;
      for(int num : nums){
        map.put(num , map.getOrDefault(num , 0) + 1);
      }
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //    .println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        ans = entry.getKey();
        if(entry.getValue() > (nums.length)/2){
            return ans;
        }
      }
      return ans;
    }
}