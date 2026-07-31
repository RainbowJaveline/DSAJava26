class Solution {
   public static String removeDuplicates(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i< s.length() ; i++){
            boolean isDuplicate = false;
            while(!stack.isEmpty() && stack.peek() == s.charAt(i)){
                isDuplicate = true;
                stack.pop();
            }
            if(!isDuplicate){
                stack.push(s.charAt(i));
            }
            continue;
        }
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();

    }
}