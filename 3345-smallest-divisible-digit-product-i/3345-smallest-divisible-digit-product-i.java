class Solution {
    public int smallestNumber(int n, int t) {
       int ans = 0;
       for(int i=n ; i<=100 ; i++){
        int prod = digitProd(i);
        if(prod % t == 0){
            ans = i;
            break;
        }
       } 
       return ans;
    }
    public static int digitProd(int n){
        int prod = 1;
        while(n != 0){
            int rem = n % 10;
            prod = prod * rem;
            n = n / 10;
        }
        return prod;
    }
}