class Solution {
    //my brute force solution 
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        // if(n == 1) return new int[]{-1};
        for(int i = 0 ; i< n ; i++){
            int ele = arr[i];
            int j = i+1;
            int max = Integer.MIN_VALUE;
            while(j<arr.length){
                max = Math.max(max , arr[j]);
                j++;
            }
            arr[i] = max;
        }
        arr[n - 1] = -1;
        return arr;
    }
}