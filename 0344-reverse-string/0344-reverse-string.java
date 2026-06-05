class Solution {
    public void reverseString(char[] s) {
        // int i=0 , j = s.length - 1;
        // while(i<=j){
        //     char temp = s[i];
        //     s[i] = s[j];
        //     s[j] = temp;
        //     i++;
        //     j--;
        // }
        helper(s , 0 , s.length-1);
    }
    static void helper(char[] s , int i , int j){
        if(i>=j) return ;
        char char1 = s[i];
        s[i] = s[j];
        s[j] = char1;
        helper(s , i+1 , j-1);
    }
}
