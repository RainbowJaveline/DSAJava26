class Solution {
    public int largestRectangleArea(int[] heights) {
      int maxArea = 0;
      Stack<Integer> stack = new Stack<>();
      for(int i=0; i<heights.length ; i++){
        while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
            int element = stack.peek();
            stack.pop();
            int nse = i;
            int pse = stack.empty() ? -1 : stack.peek();
            maxArea = Math.max(heights[element] * (nse-pse-1) , maxArea);
        }
        stack.push(i);
      }

      while(!stack.isEmpty()){
        int nse = heights.length;
        int element = stack.pop();
        int pse = stack.empty() ? -1 : stack.peek();
        maxArea = Math.max(heights[element] * (nse-pse-1) , maxArea);
      }

      return maxArea;  
    }
}