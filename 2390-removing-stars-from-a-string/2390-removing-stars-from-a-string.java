class Solution {
    public String removeStars(String s) {
        char[] stack = new char[s.length()];
        int ptr = -1;
        int count = 0;
        for(int i=0; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                count++;
            }else{
                stack[++ptr] = ch;
            }
            while(ptr!= -1 && count != 0){
                ptr--;
                count--;
            }
        }
        if(stack.length == 0){
            return "";
        }

        StringBuilder str = new StringBuilder();
        String ans = "";
        for(int i=0 ; i<=ptr ; i++){
            // ans+= stack[i];
            str.append(stack[i]);
        }

        return str.toString();
    }
}