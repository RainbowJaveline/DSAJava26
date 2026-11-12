class Solution {
       public static List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        helper(answer , 0 , s , new ArrayList<>());
        return answer;
    }

    public static void helper(List<List<String>> answer , int idx , String s ,List<String> temp){
        if(idx == s.length()){
            answer.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if(isPalindrome(s , idx , i)){
                temp.add(s.substring(idx,i+1));
                helper(answer,i+1,s,temp);
                temp.removeLast();
            }
        }

    }

    public static boolean isPalindrome(String s , int left , int right){
        if(s.length()==1){
            return true;
        }
        while(left<=right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}