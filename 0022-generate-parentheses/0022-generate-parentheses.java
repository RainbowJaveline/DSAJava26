class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        return helper(n , answer , 0 , 0, new StringBuilder());
    }

    public List<String> helper(int n , List<String> answer , int open , int close , StringBuilder temp){
        if(open == n && close == n){
            answer.add(temp.toString());
            return answer;
        }

        if(open < n){
            temp.append("(");
            helper(n , answer , open + 1 , close , temp);
            temp.deleteCharAt(temp.length()-1);
        }

        if(close < open){
            temp.append(")");
            helper(n , answer , open, close+1 , temp);
            temp.deleteCharAt(temp.length()-1);
        }
        return answer;
    }
}