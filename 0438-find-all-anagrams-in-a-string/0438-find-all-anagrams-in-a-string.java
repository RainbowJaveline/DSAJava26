class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int[] needed = new int[26];
        int[] window = new int[26];

        for (char c : p.toCharArray()) {
            needed[c - 'a']++;
        }

        int required = 0;

        // Number of characters whose frequency matters
        for (int i = 0; i < 26; i++) {
            if (needed[i] > 0) {
                required++;
            }
        }

        int formed = 0;
        int l = 0;

        for (int h = 0; h < s.length(); h++) {

            char c = s.charAt(h);
            window[c - 'a']++;

            // This character just became satisfied
            if (window[c - 'a'] == needed[c - 'a']) {
                formed++;
            }

            // Keep window size equal to p.length()
            if (h - l + 1 > p.length()) {

                char left = s.charAt(l);

                // Before removing, check if this character was satisfying
                if (window[left - 'a'] == needed[left - 'a']) {
                    formed--;
                }

                window[left - 'a']--;
                l++;
            }

            // All required characters are satisfied
            if (formed == required) {
                ans.add(l);
            }
        }

        return ans;
    }
}