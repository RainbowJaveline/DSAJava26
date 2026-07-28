class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer , Integer > map = new HashMap<>();
        for(int i = nums2.length-1 ; i>=0 ; i--){
            int ele = nums2[i];
            if(stack.isEmpty()){
                stack.push(ele);
                ans[i] = -1;
                map.put(ele , ans[i]);
                continue;
            }

            if(stack.peek() > ele){
                stack.push(ele);
                ans[i] = stack.peek();
                map.put(ele , ans[i]);
            }

            while(!stack.isEmpty() && stack.peek() <= ele){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = -1;
                stack.push(ele);
                map.put(ele , ans[i]);
            }else{
                ans[i] = stack.peek();
                stack.push(ele);
                map.put(ele , ans[i]);
            }

        }

        for(int i = 0 ; i< nums1.length ; i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}