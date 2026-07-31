class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] stack = new int[n];
        int top = -1;
        //Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];
        for(int i = n-1 ; i>=0 ; i--){
            int element = temperatures[i];
            while(top!= -1 && temperatures[stack[top]] <= element){
                top--;
            }
            answer[i] = top == -1 ? 0 : stack[top] - i;
            stack[++top] = i;
            //stack.push(i);
        }
        return answer;
    }
}