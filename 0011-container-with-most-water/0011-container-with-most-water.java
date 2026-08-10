class Solution {
    public int maxArea(int[] height) {
       int l = 0;
       int r = height.length - 1;
       int max = 0;
       while(l<= r){
        int base = r-l;
        int minHeight = Math.min(height[l] , height[r]);
        int currarea = minHeight * base;
        max = Math.max(max , currarea);
        if(height[l] < height[r]){
            l++;
        }else{
            r--;
        }
       }
       return max; 
    }
}