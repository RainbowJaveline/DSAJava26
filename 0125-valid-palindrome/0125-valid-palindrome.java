class Solution {
    public boolean isPalindrome(String s) {
         String str = s.toLowerCase().replaceAll("\\s" , ""); // important step it is
        System.out.println(str);
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            boolean c1 = Character.isLetterOrDigit(str.charAt(i));
            boolean c2 = Character.isLetterOrDigit(str.charAt(j));
            if(c1 && c2 && str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            } else if (!c1) {
                i++;
            } else if (!c2){
                j--;
            }else{
                return false;
            }
        }
        return true;

    }
}