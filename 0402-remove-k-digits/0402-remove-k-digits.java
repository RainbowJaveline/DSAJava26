class Solution {
    public String removeKdigits(String num, int k) {
       if(num.length() == k) return "0";
        if(num.equals("0")) return "0";
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(k>0){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()) return "0";
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        StringBuilder ans = res.reverse();
        int i = 0;
        while(i<ans.length() && ans.charAt(i) < '1'){
            i++;
        }
        ans.delete(0,i);
        if(ans.length() == 0) return "0";
        return ans.toString();
    }
}