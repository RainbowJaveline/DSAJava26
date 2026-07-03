class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> arrPos = new ArrayList<>();
        ArrayList<Integer> arrNeg = new ArrayList<>();
        int[] arr = new int[nums.length];
        for(int el : nums){
            if(el < 1){
                arrNeg.add(el);
            }else{
                arrPos.add(el);
            }
        }

        int nPos = 0;
        int nNeg = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0 && nPos < arrPos.size()) {
                arr[i] = arrPos.get(nPos);
                nPos++;
            } else {
                arr[i] = arrNeg.get(nNeg);
                nNeg++;
            }
        }

        return arr;

    }
}