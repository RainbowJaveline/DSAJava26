class Solution {

    private static final Map<Integer, Map<Integer, Integer>> FACTORS = Map.of(
        0, Map.of(),
        1, Map.of(),
        2, Map.of(2, 1),
        3, Map.of(3, 1),
        4, Map.of(2, 2),
        5, Map.of(5, 1),
        6, Map.of(2, 1, 3, 1),
        7, Map.of(7, 1),
        8, Map.of(2, 3),
        9, Map.of(3, 2)
    );

    public String smallestNumber(String num, long t) {

        // Factorize t
        Map<Integer, Integer> target = factorize(t);

        // If t has a prime factor other than 2,3,5,7
        if (target == null) {
            return "-1";
        }

        // Convert prime factors into minimum digit counts
        Map<Integer, Integer> targetDigits = toDigitCounts(target);

        int minDigits = totalDigits(targetDigits);

        // If we need more digits than num has,
        // directly construct the smallest possible number.
        if (minDigits > num.length()) {
            return buildNumber(targetDigits);
        }

        // Factors present in the whole num
        Map<Integer, Integer> current = factorizeDigits(num);

        // If num itself is valid and contains no zero
        if (num.indexOf('0') == -1 && containsAll(current, target)) {
            return num;
        }

        int firstZero = num.indexOf('0');

        if (firstZero == -1) {
            firstZero = num.length();
        }

        /*
         * Work backwards.
         *
         * We want to change the rightmost possible digit.
         */
        for (int i = num.length() - 1; i >= 0; i--) {

            int currentDigit = num.charAt(i) - '0';

            // Remove current digit from prefix
            removeFactors(current, currentDigit);

            /*
             * If there is a zero before this position,
             * the prefix would contain zero.
             *
             * Such a prefix cannot be part of the answer.
             */
            if (i > firstZero) {
                continue;
            }

            int remainingPositions = num.length() - i - 1;

            /*
             * Try the smallest possible digit
             * greater than currentDigit.
             */
            for (int newDigit = currentDigit + 1;
                 newDigit <= 9;
                 newDigit++) {

                // Factors supplied by prefix + newDigit
                Map<Integer, Integer> supplied =
                        new HashMap<>(current);

                addFactors(supplied, newDigit);

                // Factors still required
                Map<Integer, Integer> remaining =
                        subtract(target, supplied);

                // Minimum number of digits required
                Map<Integer, Integer> suffixDigits =
                        toDigitCounts(remaining);

                int needed =
                        totalDigits(suffixDigits);

                /*
                 * If the remaining factors fit,
                 * we have found the smallest valid answer.
                 */
                if (needed <= remainingPositions) {

                    int ones =
                            remainingPositions - needed;

                    return num.substring(0, i)
                            + newDigit
                            + "1".repeat(ones)
                            + buildNumber(suffixDigits);
                }
            }
        }

        /*
         * No valid number with the same length.
         *
         * Since minDigits <= num.length(),
         * num.length() + 1 digits are enough.
         */
        Map<Integer, Integer> finalDigits =
                toDigitCounts(target);

        int ones =
                num.length() + 1 - totalDigits(finalDigits);

        return "1".repeat(ones)
                + buildNumber(finalDigits);
    }


    // ---------------------------------------------------------
    // Factorize t
    // ---------------------------------------------------------

    private Map<Integer, Integer> factorize(long t) {

        Map<Integer, Integer> result = new HashMap<>();

        result.put(2, 0);
        result.put(3, 0);
        result.put(5, 0);
        result.put(7, 0);

        int[] primes = {2, 3, 5, 7};

        for (int p : primes) {

            while (t % p == 0) {
                result.put(p, result.get(p) + 1);
                t /= p;
            }
        }

        // Remaining factor cannot be produced by any digit
        if (t != 1) {
            return null;
        }

        return result;
    }


    // ---------------------------------------------------------
    // Factorize all digits of num
    // ---------------------------------------------------------

    private Map<Integer, Integer> factorizeDigits(String num) {

        Map<Integer, Integer> result = new HashMap<>();

        result.put(2, 0);
        result.put(3, 0);
        result.put(5, 0);
        result.put(7, 0);

        for (char ch : num.toCharArray()) {

            int digit = ch - '0';

            addFactors(
                result,
                digit
            );
        }

        return result;
    }


    // ---------------------------------------------------------
    // Add factors of one digit
    // ---------------------------------------------------------

    private void addFactors(
            Map<Integer, Integer> count,
            int digit) {

        Map<Integer, Integer> factors =
                FACTORS.get(digit);

        for (Map.Entry<Integer, Integer> entry
                : factors.entrySet()) {

            int prime = entry.getKey();
            int amount = entry.getValue();

            count.put(
                prime,
                count.get(prime) + amount
            );
        }
    }


    // ---------------------------------------------------------
    // Remove factors of one digit
    // ---------------------------------------------------------

    private void removeFactors(
            Map<Integer, Integer> count,
            int digit) {

        Map<Integer, Integer> factors =
                FACTORS.get(digit);

        for (Map.Entry<Integer, Integer> entry
                : factors.entrySet()) {

            int prime = entry.getKey();
            int amount = entry.getValue();

            count.put(
                prime,
                count.get(prime) - amount
            );
        }
    }


    // ---------------------------------------------------------
    // target - supplied
    // ---------------------------------------------------------

    private Map<Integer, Integer> subtract(
            Map<Integer, Integer> target,
            Map<Integer, Integer> supplied) {

        Map<Integer, Integer> result =
                new HashMap<>();

        for (int prime : new int[]{2, 3, 5, 7}) {

            int remaining =
                    target.get(prime)
                    - supplied.get(prime);

            result.put(
                prime,
                Math.max(0, remaining)
            );
        }

        return result;
    }


    // ---------------------------------------------------------
    // Convert prime factors into digits
    // ---------------------------------------------------------

    private Map<Integer, Integer> toDigitCounts(
            Map<Integer, Integer> factors) {

        int c2 = factors.get(2);
        int c3 = factors.get(3);
        int c5 = factors.get(5);
        int c7 = factors.get(7);

        Map<Integer, Integer> result =
                new HashMap<>();

        for (int i = 2; i <= 9; i++) {
            result.put(i, 0);
        }

        // 2^3 -> 8
        result.put(8, c2 / 3);
        c2 %= 3;

        // 3^2 -> 9
        result.put(9, c3 / 2);
        c3 %= 2;

        // 2^2 -> 4
        result.put(4, c2 / 2);
        c2 %= 2;

        // 2 * 3 -> 6
        if (c2 == 1 && c3 == 1) {

            result.put(6, 1);

            c2 = 0;
            c3 = 0;
        }

        /*
         * Special case:
         *
         * 2^2 * 3
         *
         * Instead of 4,3
         * use 2,6
         */
        if (c2 == 0 &&
            c3 == 1 &&
            result.get(4) > 0) {

            result.put(
                4,
                result.get(4) - 1
            );

            result.put(2, 1);
            result.put(6, 1);

            c3 = 0;
        }

        // Remaining 2
        if (c2 > 0) {
            result.put(2, result.get(2) + c2);
        }

        // Remaining 3
        if (c3 > 0) {
            result.put(3, result.get(3) + c3);
        }

        // 5
        result.put(5, c5);

        // 7
        result.put(7, c7);

        return result;
    }


    // ---------------------------------------------------------
    // Count total number of digits required
    // ---------------------------------------------------------

    private int totalDigits(
            Map<Integer, Integer> digitCounts) {

        int total = 0;

        for (int digit = 2; digit <= 9; digit++) {
            total += digitCounts.get(digit);
        }

        return total;
    }


    // ---------------------------------------------------------
    // Build smallest number from digit counts
    // ---------------------------------------------------------

    private String buildNumber(
            Map<Integer, Integer> digitCounts) {

        StringBuilder sb = new StringBuilder();

        /*
         * Digits are already being added in ascending order,
         * so the resulting number is the smallest possible.
         */
        for (int digit = 2; digit <= 9; digit++) {

            int count = digitCounts.get(digit);

            while (count-- > 0) {
                sb.append(digit);
            }
        }

        return sb.toString();
    }


    // ---------------------------------------------------------
    // Check if available contains all required factors
    // ---------------------------------------------------------

    private boolean containsAll(
            Map<Integer, Integer> available,
            Map<Integer, Integer> required) {

        for (int prime : new int[]{2, 3, 5, 7}) {

            if (available.get(prime)
                    < required.get(prime)) {

                return false;
            }
        }

        return true;
    }
}