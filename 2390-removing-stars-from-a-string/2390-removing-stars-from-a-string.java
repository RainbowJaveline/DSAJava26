class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i=0; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                count++;
            }else{
                stack.push(ch);
            }
            while(!stack.isEmpty() && count != 0){
                stack.pop();
                count--;
            }
        }
        if(stack.size() == 0){
            return "";
        }

        StringBuilder str = new StringBuilder();
        String ans = "";
        while(!stack.isEmpty()){
            str.append(stack.peek());
            stack.pop();
        }

        return str.reverse().toString();
    }
}