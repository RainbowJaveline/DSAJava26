class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //add all the psotive integers
        for(int num : nums){
            if(num > 0){
                map.put(num ,  1);
            }
        }

        //check whether it is present in the HashMap
        for(int i = 1 ; i<=nums.length+1 ; i++ ){
            if(!map.containsKey(i)){
                return i;
            }
        }
        return nums.length + 1;
    }
}