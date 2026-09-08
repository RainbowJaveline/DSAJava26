class Solution {
    public int countCommas(int n) {
        int original = n ;
        int count = 0;
        while(n != 0){
            n = n / 10;
            count++;
        }
        if(count <= 3) return 0;
        int ans = 1;
        if(original >= 1000 && original <= 100000){
            int multi = original - 1000;
            ans = ans * multi + 1;
        }
        return ans;
    }
}