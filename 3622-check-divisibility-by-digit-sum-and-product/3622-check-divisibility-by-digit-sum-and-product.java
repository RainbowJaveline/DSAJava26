class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int sum = 0;
        int prod = 1;
        while(num!=0){
            int lastDigit = num % 10;
            sum += lastDigit;
            prod *= lastDigit;
            num /= 10;
        }

        return n % (sum + prod) == 0;
    }
}