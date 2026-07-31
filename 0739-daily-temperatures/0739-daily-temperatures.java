class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];
        for(int i = n-1 ; i>=0 ; i--){
            int element = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] <= element){
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return answer;
    }
}