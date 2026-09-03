class Solution {
    public boolean uniformArray(int[] nums1) {
        return true;
        // int minOdd = Integer.MAX_VALUE;
        // int minEven = Integer.MAX_VALUE;
        // boolean hasOdd = false, hasEven = false;

        // for (int x : nums1) {
        //     if (x % 2 != 0) {
        //         hasOdd = true;
        //         minOdd = Math.min(minOdd, x);
        //     } else {
        //         hasEven = true;
        //         minEven = Math.min(minEven, x);
        //     }
        // }

        // if (!hasOdd || !hasEven) return true; // already uniform
        // return minOdd < minEven;
    }
}