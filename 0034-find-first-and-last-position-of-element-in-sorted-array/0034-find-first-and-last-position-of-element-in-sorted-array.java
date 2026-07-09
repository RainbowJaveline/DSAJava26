class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1 , -1};
        int first  = search(nums , target , true);
        int last = search(nums , target , false);
        ans[0] = first;
        ans[1] = last;
        return ans;
    }

    public static int search(int[] nums , int target , boolean findFirst){
        int ans = -1;
        int low = 0 ;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] > target){
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                ans = mid;
                if(findFirst){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            } 
        }
        return ans; 
    }
}