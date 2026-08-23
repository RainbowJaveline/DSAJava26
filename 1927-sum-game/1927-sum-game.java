class Solution {
    public boolean sumGame(String num) {
         int n = num.length();
        int half = n / 2;

        int leftSum = 0;
        int rightSum = 0;

        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < half; i++) {
            char ch = num.charAt(i);

            if (ch == '?') {
                leftQ++;
            } else {
                leftSum += ch - '0';
            }
        }

        for (int i = half; i < n; i++) {
            char ch = num.charAt(i);

            if (ch == '?') {
                rightQ++;
            } else {
                rightSum += ch - '0';
            }
        }

        // Odd number of '?' -> Alice can always force a win
        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        // Difference in number of '?' must be compensated
        int qDiff = leftQ - rightQ;
        int sumDiff = leftSum - rightSum;

        return sumDiff != -9 * qDiff / 2;
    }
}