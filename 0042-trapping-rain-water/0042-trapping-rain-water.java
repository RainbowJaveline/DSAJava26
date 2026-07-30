class Solution {
    public int trap(int[] height) {
        int total = 0;
        int[] leftMax = prefixMax(height);
        int[] rightMax = suffixMax(height);
        for(int i=0 ; i<height.length ; i++){
           if(height[i] < leftMax[i] && height[i] < rightMax[i]){
             total += Math.min(leftMax[i],rightMax[i]) - height[i];
           }
        }
        return total;
    }

    public static int[] prefixMax(int[] height){
        int[] pM = new int[height.length];
        pM[0] = height[0];
        for(int i = 1 ; i< pM.length ; i++){
            pM[i] = Math.max(pM[i-1] , height[i]);
        }
        return pM;
    }
    public static int[] suffixMax(int[] height){
        int[] sM = new int[height.length];
        sM[height.length-1] = height[height.length-1];
        for(int i = height.length-2 ; i>= 0 ; i--){
            sM[i] = Math.max(sM[i+1] , height[i]);
        }
        return sM;
    }
}