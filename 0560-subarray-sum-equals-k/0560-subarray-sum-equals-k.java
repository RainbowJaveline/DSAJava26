class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: A prefix sum of 0 has occurred 1 time
        map.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if (currentSum - k) exists in the map
            int rem = currentSum - k;
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            
            // Add the current prefix sum to the map
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;

        //for better understanding of this problem we need this code 
        // int n = nums.length;
        // HashMap<Integer,Integer> map = new HashMap<>();
        // int count = 1;
        // int[] prefixSum = new int[n];
        // prefixSum[0] = nums[0];
        // for(int i= 1 ; i<n ; i++){
        //     prefixSum[i] = prefixSum[i-1] + nums[i];
        // }

        // for(int j = 0; j<n ; j++){
        //     if(prefixSum[j] == k) count++;
        //     int subarrayVal = prefixSum[j] - k;
        //     if(map.containsKey(subarrayVal)){
        //         int numberOfSubarray = map.get(subarrayVal);
        //         count += numberOfSubarray;
        //     }
        //     if(!map.containsKey(subarrayVal)){
        //         map.put(prefixSum[j] , map.getOrDefault(nums[j],0)+1);
        //     }

        //     map.put(prefixSum[j] , map.get(nums[j])+1);
        // }
        // return count;
        //This is a Brute Force Solution ...
        // for(int i=0 ; i<nums.length ; i++){
        //     int sum = 0;
        //     for(int j=i;j<nums.length;j++){
        //         sum += nums[j];
        //         if(sum == k){
        //             count++;
        //         }
        //     }
        // }
        // return count;
    }
}