class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        int[] freq = new int[nums.length+1];
        for(int i =0 ; i<nums.length ; i++){
            freq[nums[i]]++;
        }

        List<Integer> list = new ArrayList<>();
        if(nums.length == 1){
            return list;
        }
        for(int i =0 ; i< freq.length ; i++){
            if(freq[i] == 2){
                list.add(i);
            }
        }

        return list;
    }
}