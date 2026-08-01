class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // HashMap<Character,Integer> ransom = new HashMap<>();
        // HashMap<Character,Integer> maga = new HashMap<>();
        // for(char ch : ransomNote.toCharArray()){
        //     ransom.put(ch , ransom.getOrDefault(ch,0)+1);
        // }
        // for(char ch : magazine.toCharArray()){
        //     maga.put(ch , maga.getOrDefault(ch,0)+1);
        // }
        // int length = ransomNote.length() > magazine.length() ? magazine.length() : ransomNote.length();
        
        //return magazine.indexOf(ransomNote) == -1 ? false : true;
        int i = 0;
        int j = 0;
        char[] ran = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();
        Arrays.sort(ran);
        Arrays.sort(maga);
        while(j < maga.length && i < ran.length){
            while((j < maga.length && i < ran.length) && (ran[i] == maga[j])){
                    i++;
                    j++;
                    if(i == ransomNote.length()){
                        return true;
                    }
            }
            j++;
        }
        return false;
    }
}