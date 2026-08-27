class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];

        // Count characters of s
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char[] ans = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {

            int idx = target.charAt(i) - 'a';

            // Case 1: We can match target[i]
            if (freq[idx] > 0) {
                ans[i] = target.charAt(i);
                freq[idx]--;
            } 
            else {
                // Cannot match target[i].
                // First, try to make THIS position greater.
                String result = makeGreater(ans, i, freq, target);

                if (!result.equals("")) {
                    return result;
                }

                // If impossible at this position,
                // backtrack to previous positions.
                return backtrack(ans, i, freq, target);
            }
        }

        // We matched target exactly.
        // Need STRICTLY greater, so backtrack.
        return backtrack(ans, s.length(), freq, target);
    }

    // Try making position 'pos' greater than target[pos]
    private String makeGreater(char[] ans, int pos,
                               int[] freq, String target) {

        int targetIdx = target.charAt(pos) - 'a';

        // Find smallest character > target[pos]
        for (int c = targetIdx + 1; c < 26; c++) {

            if (freq[c] > 0) {

                StringBuilder sb = new StringBuilder();

                // Prefix stays equal to target
                for (int i = 0; i < pos; i++) {
                    sb.append(ans[i]);
                }

                // Make current position greater
                sb.append((char) ('a' + c));

                freq[c]--;

                // Add remaining characters in sorted order
                appendRemaining(sb, freq);

                return sb.toString();
            }
        }

        return "";
    }

    // Backtrack to find a previous position
    // that can be increased.
    private String backtrack(char[] ans, int pos,
                             int[] freq, String target) {

        for (int i = pos - 1; i >= 0; i--) {

            // Put back ans[i]
            freq[ans[i] - 'a']++;

            int targetIdx = target.charAt(i) - 'a';

            // Find smallest character > target[i]
            for (int c = targetIdx + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    StringBuilder sb = new StringBuilder();

                    // Keep prefix unchanged
                    for (int j = 0; j < i; j++) {
                        sb.append(ans[j]);
                    }

                    // Make position i greater
                    sb.append((char) ('a' + c));

                    freq[c]--;

                    // Smallest possible suffix
                    appendRemaining(sb, freq);

                    return sb.toString();
                }
            }
        }

        return "";
    }

    private void appendRemaining(StringBuilder sb, int[] freq) {

        for (int c = 0; c < 26; c++) {

            while (freq[c] > 0) {
                sb.append((char) ('a' + c));
                freq[c]--;
            }
        }
    }
}