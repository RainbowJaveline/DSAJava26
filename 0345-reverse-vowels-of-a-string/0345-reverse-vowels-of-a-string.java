class Solution {
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int i=0;
        int j=array.length-1;
        String vowel = "aeiouAEIOU";
        while(i<j){
            if(vowel.indexOf(array[i])!=-1 && vowel.indexOf(array[j])!=-1){
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }else if(vowel.indexOf(array[j])==-1){
                j--;
            }else{
                i++;
            }
        }
        //return String.valueOf(array);
        return new String(array);
    }
}