class Solution {
    public static int minimumDeletions(int[] nums) {
        if(nums.length == 1) return 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int ansMin = 0;
        int ansMax = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int maxIdx = 0;
        int minIdx = 0;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] == max){
                maxIdx = i;
            }
            if(nums[i] == min){
                minIdx = i;
            }
        }

        if((maxIdx == 0 && minIdx == nums.length-1) || (maxIdx == nums.length-1 && minIdx == 0)){
            return 2;
        }
        int maxClose = nums.length - maxIdx;
        int minClose = nums.length - minIdx;
        int FromEnd = 0;
        int FromStart = 0;
        int currMin1 = 0;
        int currMin2 = 0;
        if(maxIdx < minIdx){
            FromEnd = maxClose;
            FromStart = minIdx+1;
            currMin1 = Math.min(FromEnd,FromStart);
            currMin1 = Math.min(currMin1 ,maxIdx + minClose + 1);
            return currMin1;
        }else{
            FromEnd = minClose;
            FromStart = maxIdx+1;
            currMin2 = Math.min(FromEnd,FromStart);
            currMin2 = Math.min(currMin2 ,minIdx + maxClose + 1);
            return currMin2;
        }
        // boolean delFromL = false;
        // if(maxClose >= maxIdx && minClose >= minIdx){
        //     if(maxIdx > minIdx){
        //         return maxIdx + 1;
        //     }else{
        //         return minIdx + 1;
        //     }
        // }else if(maxClose < maxIdx && minClose < minIdx){
        //     if(maxClose > minClose){
        //         return maxClose + 1;
        //     }else{
        //         return minClose + 1;
        //     }
        // }else{
        //     if(minIdx < maxIdx){
        //         return minIdx + maxClose + 1;
        //     }else{
        //         return maxIdx + minClose + 1;
        //     }
        // }
    }
}