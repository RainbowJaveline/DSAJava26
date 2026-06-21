class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] arr = new int[n+1];
        for(int i=0;i<=n;i++){
             arr[i]++;
        }
        for(int ele : nums){
            arr[ele]--;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                ans = i;
            }
        }
        return ans;
    }
}