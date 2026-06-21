class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k= k%nums.length;   
        //reverse array
        reverse(nums , 0 , n-1);
        //reverse from d
        reverse(nums,0,k-1);
        //again reverse from d
        reverse(nums,k,n-1);
    }

      public static void reverse(int[] arr,int i,int j){
        while(i<=j){
            if(arr.length == 1) break;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}