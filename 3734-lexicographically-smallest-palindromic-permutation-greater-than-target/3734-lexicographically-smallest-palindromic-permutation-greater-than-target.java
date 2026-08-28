
class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // Count characters
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Check if palindrome is possible
        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        // Frequency for first half
        int halfLen = n / 2;
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        String targetHalf = target.substring(0, halfLen);

        // -------------------------------------------------
        // Try to match targetHalf as much as possible
        // -------------------------------------------------

        int[] remaining = halfFreq.clone();
        char[] half = new char[halfLen];

        int i = 0;

        while (i < halfLen) {

            int c = targetHalf.charAt(i) - 'a';

            if (remaining[c] == 0) {
                break;
            }

            half[i] = targetHalf.charAt(i);
            remaining[c]--;

            i++;
        }

        // -------------------------------------------------
        // CASE 1:
        // We can form targetHalf completely
        // -------------------------------------------------

        if (i == halfLen) {

            String candidate = buildPalindrome(
                new String(half),
                middle,
                n
            );

            // Already strictly greater
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }

            // Need next permutation
            String next = nextPermutation(new String(half));

            if (next == null) {
                return "";
            }

            return buildPalindrome(next, middle, n);
        }

        // -------------------------------------------------
        // CASE 2:
        // targetHalf cannot be formed exactly
        //
        // Try to make some position larger.
        // Start from i itself!
        // -------------------------------------------------

        for (int j = i; j >= 0; j--) {

            int[] temp = remaining.clone();

            // Restore characters from i-1 down to j
            for (int k = i - 1; k >= j; k--) {
                temp[half[k] - 'a']++;
            }

            int current = targetHalf.charAt(j) - 'a';

            // Try the smallest available character
            // that is greater than target[j]
            for (int c = current + 1; c < 26; c++) {

                if (temp[c] == 0) {
                    continue;
                }

                char[] result = new char[halfLen];

                // Prefix remains equal to target
                for (int k = 0; k < j; k++) {
                    result[k] = targetHalf.charAt(k);
                }

                // Make this position larger
                result[j] = (char) ('a' + c);
                temp[c]--;

                // Fill the rest with smallest characters
                int pos = j + 1;

                for (int x = 0; x < 26; x++) {

                    while (temp[x] > 0) {
                        result[pos++] = (char) ('a' + x);
                        temp[x]--;
                    }
                }

                return buildPalindrome(
                    new String(result),
                    middle,
                    n
                );
            }
        }

        return "";
    }

    // -------------------------------------------------
    // Build palindrome
    // -------------------------------------------------

    private String buildPalindrome(String half, char middle, int n) {

        StringBuilder sb = new StringBuilder();

        sb.append(half);

        if (n % 2 == 1) {
            sb.append(middle);
        }

        sb.append(new StringBuilder(half).reverse());

        return sb.toString();
    }

    // -------------------------------------------------
    // Next lexicographical permutation
    // -------------------------------------------------

    private String nextPermutation(String s) {

        char[] arr = s.toCharArray();

        int i = arr.length - 2;

        // Find first position where arr[i] < arr[i + 1]
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // Already the largest permutation
        if (i < 0) {
            return null;
        }

        // Find smallest element greater than arr[i]
        int j = arr.length - 1;

        while (arr[j] <= arr[i]) {
            j--;
        }

        // Swap
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // Reverse suffix
        int left = i + 1;
        int right = arr.length - 1;

        while (left < right) {

            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }
}