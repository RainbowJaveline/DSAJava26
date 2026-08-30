class Solution {
    public static int minimumDeletions(int[] nums) {
        if(nums.length == 1) return 1;
        int n = nums.length;
        int maxIdx = 0;
        int minIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
        }
        // int maxClose = nums.length - maxIdx;
        // int minClose = nums.length - minIdx;
        // int FromEnd = 0;
        // int FromStart = 0;
        int currMin1 = 0;
        int currMin2 = 0;
        if(maxIdx < minIdx){
            currMin1 = Math.min(n - maxIdx,minIdx+1);
            currMin1 = Math.min(currMin1 ,maxIdx + n - minIdx + 1);
            return currMin1;
        }else{
            currMin2 = Math.min(n - minIdx,maxIdx+1);
            currMin2 = Math.min(currMin2 ,minIdx + n - maxIdx + 1);
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