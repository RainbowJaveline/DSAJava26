class Solution {
    public int[] validSequence(String word1, String word2) {
        int[] answer = new int[word2.length()];
        int j = word2.length() - 1;
        int[] lastPos = new int[word2.length()];
        for(int i = word1.length() - 1 ; i>= 0 ; i--){
            if(j >= 0 && (word1.charAt(i) == word2.charAt(j))){
                lastPos[j] = i;
                j--;
            }
        }
        int skip = 0;
        j = 0;
        int idx = 0;
        for(int i=0 ; i<word1.length() ; i++){
            if(j == word2.length()){
                break;
            }
            if(word1.charAt(i) == word2.charAt(j) || (skip == 0 && (j == word2.length() - 1 || i < lastPos[j+1]))){
                if(word1.charAt(i) != word2.charAt(j)){
                    skip = 1;
                }
                answer[idx] = i;
                j++;
                idx++;
            }
        }

        if(j!= word2.length()){
            return new int[]{};
        }
        return answer;

    }
}