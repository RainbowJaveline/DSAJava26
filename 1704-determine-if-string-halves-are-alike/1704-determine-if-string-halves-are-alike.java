class Solution {
    public boolean halvesAreAlike(String s) {
        String lowerS = s.toLowerCase();
        int n = lowerS.length();
        String a = lowerS.substring(0,n/2);
        System.out.println(a);
        String b = lowerS.substring(n/2,n);
        System.out.println(b);
        int countA = 0;
        for(char c: a.toCharArray()){
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                countA++;
            }
        }
        int countB = 0;
        for(char c: b.toCharArray()){
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                countB++;
            }
        }
        return countA == countB;
    }
}