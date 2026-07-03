class Solution {
    public void nextPermutation(int[] nums) {
         int idx = -1;
        for(int i= nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx = i;
                break;
            }
        }
        if(idx == -1){
            rev(nums,0 , nums.length - 1);
            return ;
        }else{
            //once got the idx what you do is you swap it with the first greater element from the end
            for (int i = nums.length-1; i>idx ; i--) {
                if(nums[i] > nums[idx]){
                    swap(nums , i , idx);
                    break;
                }
            }
            //now sort the array from the start - idx+1 upto length of array
             rev(nums , idx+1 , nums.length-1);
            
        }
    }

    public static void swap(int[] nums , int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void rev(int[] nums , int start , int end){
        while(start<=end){
            swap(nums,start , end);
            start++;
            end--;
        }
}

}
