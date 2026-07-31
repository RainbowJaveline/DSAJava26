class Solution {
   public static String removeDuplicates(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i< s.length() ; i++){
           if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
            char dup = stack.pop();
            while(!stack.isEmpty() && dup == stack.peek()){
                stack.pop();
            }
            continue;
           }
           stack.push(s.charAt(i));
        }
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();

    }
}