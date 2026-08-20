class Solution {
    public int[] resultArray(int[] nums) {
       int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int n = nums.length;
        int idx1 = 0;
        int idx2 = 0;
        for(int i = 2 ; i<nums.length ; i++){
            if(arr1[idx1] > arr2[idx2]){
                arr1[idx1+1] = nums[i];
                idx1++;
            }else{
                arr2[idx2+1] = nums[i];
                idx2++;
            }
        }

        int[] ans = new int[nums.length];
        int i = 0;
        int j = 0;
        while(arr1[i] != 0){
            ans[i] = arr1[i];
            i++;
        }

        while(arr2[j] != 0){
            ans[i+j] = arr2[j];
            j++;
        }
        return ans;
    }
}