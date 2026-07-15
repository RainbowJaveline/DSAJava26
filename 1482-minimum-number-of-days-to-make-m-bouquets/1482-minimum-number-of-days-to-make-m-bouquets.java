class Solution {
    public static int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k > bloomDay.length) return -1;
        int low = minValue(bloomDay);
        int high = maxValue(bloomDay);
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(possible(bloomDay , mid , m , k)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean possible(int[] arr , int day , int m , int k){
        int count = 0;
        int noOfBouquets = 0;
        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i] <= day){
                count++;
            }else{
                noOfBouquets+= (count/k);
                count = 0;
            }
        }
        noOfBouquets += (count/k);
        if(noOfBouquets >= m) return true;
        return false;
    }

    public static int maxValue(int[] bloomDay){
        int num = Integer.MIN_VALUE;
        for(int n : bloomDay){
            if(num < n){
                num = n;
            }
        }
        return num;
    }

    public static int minValue(int[] bloomDay){
        int num = Integer.MAX_VALUE;
        for(int n : bloomDay){
            if(n < num){
                num = n;
            }
        }
        return num;
    }
}