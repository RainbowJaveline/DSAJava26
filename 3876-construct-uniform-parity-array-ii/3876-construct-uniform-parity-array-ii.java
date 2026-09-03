class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        boolean hasOdd = false, hasEven = false;

        for (int x : nums1) {
            if (x % 2 != 0) {
                hasOdd = true;
                minOdd = Math.min(minOdd, x);
            } else {
                hasEven = true;
                minEven = Math.min(minEven, x);
            }
        }

        if (!hasOdd || !hasEven) return true; // already uniform
        return minOdd < minEven;
        // boolean ifAllOdd = nums1[0] % 2 != 0 ? true : false;
        // boolean ifAllEven = nums1[0] % 2 == 0 ? true : false;
        // int[] nums2 = new int[nums1.length];
        // int minOdd = Integer.MAX_VALUE;
        // if(ifAllOdd){
        //     for(int i = 0 ; i<nums1.length ; i++){
        //     if(nums1[i] % 2 != 0){
        //         nums2[i] = nums1[i]; 
        //         minOdd = Math.min(minOdd,nums1[i]);
        //     }else{
        //         ifAllOdd = false;
        //         break;
        //     }
        // }
        // }
        
        // int minEven = Integer.MAX_VALUE;
        // if(ifAllEven){
        //     for(int i = 0 ; i<nums1.length ; i++){
        //         if(nums1[i] % 2 == 0){
        //             nums2[i] = nums1[i]; 
        //             minEven = Math.min(minEven,nums1[i]);
        //         }else{
        //             ifAllEven = false;
        //             break;
        //         }
        //     }   
        // }
        // if(ifAllEven || ifAllOdd ) return true;
        // return minOdd < minEven;
    }
}