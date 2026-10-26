class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastSeen = {-1, -1, -1};
        int count = 0;
        
        for (int r = 0; r < s.length(); r++) {
            // Update the last seen index for 'a', 'b', or 'c'
            lastSeen[s.charAt(r) - 'a'] = r; 
            
            // If we have seen all three characters at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                // Find the minimum of the three indices using nested Math.min
                int minIndex = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                
                // All substrings starting from index 0 up to minIndex are valid
                count += 1 + minIndex;
            }
        }
        return count;
    }
}
