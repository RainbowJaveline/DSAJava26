class Solution {
    public int sumSubarrayMins(int[] arr) {
       // this intuition combines the Next Smaller element and Previous Smaller of equal element
       //so we also need two functions for this
       int total = 0;
       int mod = (int)Math.pow(10,9) + 7;
       int[] nextSmaller = new int[arr.length];
       int[] previousSmaller = new int[arr.length];
       nextSmaller = nextSmallerElement(arr);
       previousSmaller = previousSmallerOrEqualElement(arr);
       for(int i = 0 ; i< arr.length ; i++){
            long rightPossible = nextSmaller[i] - i;
            long leftPossible = i - previousSmaller[i];
            long contribution = (rightPossible % mod) * (leftPossible % mod) % mod;
            contribution = (contribution * (arr[i] % mod)) % mod;
            total = (int)((total + contribution) % mod);
       }
       return total; 
    }

    public static int[] nextSmallerElement(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1 ; i>=0 ; i--){
            int element = arr[i];
            while(!st.isEmpty() && arr[st.peek()] >= element){
                st.pop();
            }
            ans[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return ans;
    }

    public static int[] previousSmallerOrEqualElement(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0 ; i<arr.length ; i++){
            int element = arr[i];
            while(!st.isEmpty() && arr[st.peek()] > element){
                st.pop();
            }
            ans[i] = st.isEmpty()  ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
}