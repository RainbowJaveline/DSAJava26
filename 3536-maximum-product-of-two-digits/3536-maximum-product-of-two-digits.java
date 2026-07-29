class Solution {
    public int maxProduct(int n) {
        int size = (int)Math.pow(10,5);
        int[] arr = new int[size];
        int idx = 0;
        int count = 0;
        while(n!=0){
            int lastDigit = n%10;
            arr[idx] = lastDigit;
            n = n/10;
            idx++;
            count++;
        }
        int max = 0;
        for(int i = 0 ; i<=count ; i++){
            for(int j = i+1; j<=count ; j++){
                int prod = (arr[i]) * (arr[j]);
                max = Math.max(max , prod);
            }
        }
        return max;
    }
}