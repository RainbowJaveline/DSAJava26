class Solution {
    public boolean isPalindrome(String s) {
        String newString = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        if(newString.length()==0 || newString.length()==1){
            return true;
        }
        boolean answer = isPalindromeRecursion(newString,0,newString.length()-1);
        return answer;
    }

    public boolean isPalindromeRecursion(String string , int low , int high){
        int len = high - low + 1;
        if(len==0 || len==1){
            return true;
        }
        if(string.charAt(low) != string.charAt(high)){
            return false;
        }
        return isPalindromeRecursion(string,low+1,high-1);
    }
}