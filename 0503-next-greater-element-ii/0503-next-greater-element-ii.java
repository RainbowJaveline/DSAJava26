class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //imagine array to be the double its size
        //initialise stack
        Stack<Integer> stack = new Stack<>();
        //store the ans array
        int[] ansArray = new int[nums.length];
        int n = nums.length;
        for(int i = 2*n-1 ; i>=0 ; i--){
            int element = nums[i%n];
            while(!stack.isEmpty() && stack.peek() <= element){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(element);
                ansArray[i%n] = -1;
                continue; 
            }else{
                ansArray[i%n] = stack.peek();
                stack.push(element);
                continue;
            }
        }
        return ansArray;
    }
}