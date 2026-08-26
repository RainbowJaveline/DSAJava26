class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
                int left = 0;
        int ones = 0;

        String ans = "";

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                ones++;
            }

            // We have more than k ones
            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            // We have exactly k ones
            if (ones == k) {

                // Remove unnecessary leading zeros
                while (s.charAt(left) == '0') {
                    left++;
                }

                String curr = s.substring(left, right + 1);

                // Check shortest first
                if (ans.equals("")
                        || curr.length() < ans.length()
                        || (curr.length() == ans.length()
                            && curr.compareTo(ans) < 0)) {
                    ans = curr;
                }
            }
        }

        return ans;

    }
}