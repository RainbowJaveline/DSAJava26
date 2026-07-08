class Solution {
    public String minWindow(String s, String t) {
        // String Supper  = s.toUpperCase();
        // String Tupper  = t.toUpperCase();
        int l = 0;
        int start = 0;
        int res = Integer.MAX_VALUE;
        int[] arrayT = new int[126];
        int[] arrayS = new int[126];
       for(int i = 0 ; i < t.length() ; i++){
        arrayT[t.charAt(i) - 'A']++;
       }

       for(int h = 0 ; h<s.length() ; h++){
            arrayS[s.charAt(h) - 'A']++;
            while(checkIfIncludes(arrayT,arrayS)){
                int len = h - l + 1;
                if(res > len){
                    res = len;
                    start = l ;
                }
                arrayS[s.charAt(l) - 'A']--;
                l++;
            }
       }

       return res == Integer.MAX_VALUE ? "" : s.substring(start , start+res);
    }
    public static boolean checkIfIncludes(int[] arrayT , int[] arrayS){
        for(int j=0;j<126;j++){
            if(arrayS[j] < arrayT[j]){
                return false;
            }
        }
        return true;
    }
}