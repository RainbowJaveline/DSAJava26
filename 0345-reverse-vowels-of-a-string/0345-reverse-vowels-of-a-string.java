class Solution {
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int i=0;
        int j=array.length-1;
        String vowel = "aeiouAEIOU";
        while(i<j){
            char c1 = array[i];
            char c2 = array[j];
            if(vowel.indexOf(c1)!=-1 && vowel.indexOf(c2)!=-1){
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }else if(vowel.indexOf(c2)==-1){
                j--;
            }else{
                i++;
            }
        }
        return String.valueOf(array);
    }
}