class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = maxValue(weights);
        int h = sum(weights);
        while(l<=h){
            int mid = l + (h - l)/2;
            if(possible(weights , mid , days)){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    public static boolean possible(int[] arr , int weight , int days){
        int sum = 0;
        int currDay = 1;
        for(int i = 0; i<arr.length ; i++){
            if(sum+arr[i] > weight){
                currDay++;
                sum = arr[i];
            }else{
                sum+= arr[i];
            }
        }
        return currDay<=days;
    }
    public static int sum(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        return sum;
    }

    public static int maxValue(int[] weights){
        int num = Integer.MIN_VALUE;
        for(int n : weights){
            if(num < n){
                num = n;
            }
        }
        return num;
    }
}