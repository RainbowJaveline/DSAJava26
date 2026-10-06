class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1){
            return 1;
        }
        int ans = 0;
        Stack<Character> st = new Stack<>();
        for(int i= 0 ; i<s.length() ; i++){
            if(!st.isEmpty() && st.peek() == '(' && s.charAt(i) == ')'){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }

        while(!st.isEmpty()){
            ans++;
            st.pop();
        }
        return ans;
    }
}