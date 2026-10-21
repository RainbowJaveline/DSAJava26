class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int AnswerScore = 0;
        int currScore = 0;
        int l = 0;
        int r = cardPoints.length - 1;
        for(int i = 0 ; i<k ; i++){
            AnswerScore+= cardPoints[i];
        }
        int ogK = k;
        currScore = AnswerScore;
        for(int i=k-1 ; i>= 0;i--){
            currScore = currScore - cardPoints[i] + cardPoints[r];
            r--;
            AnswerScore = Math.max(AnswerScore , currScore);
        }
        return AnswerScore;

    }
}