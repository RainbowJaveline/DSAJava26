class NumArray {
    int[] prefix_Sum;
    public NumArray(int[] nums) {
        prefix_Sum = new int[nums.length];
        prefix_Sum[0] = nums[0];
        for(int i= 1 ; i<nums.length ; i++){
            prefix_Sum[i] = prefix_Sum[i-1] + nums[i];
        }    
    }
    
    public int sumRange(int left, int right) {
        if(left==0){
            return prefix_Sum[right];
        }
        int range = prefix_Sum[right] - prefix_Sum[left-1];
        return range;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */