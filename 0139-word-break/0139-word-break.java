class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] marks = new Boolean[s.length()];
        return helper(s , wordDict , 0 , marks);
    }

    public boolean helper(String s , List<String> wordDict , int idx , Boolean[] marks){
        if(idx == s.length()){
            return true;
        }

        if(marks[idx]!=null){
            return marks[idx];
        }
        for(int i = idx ; i<s.length() ; i++){
            String part = s.substring(idx, i+1);
            if(wordDict.contains(part)){
                if(helper(s , wordDict , i+1 , marks)){
                    marks[idx] = true;
                    return true;
                }
            }
        }
        marks[idx] = false;
        return false;
    }
}