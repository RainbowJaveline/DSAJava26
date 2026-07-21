class Solution {
    public int addDigits(int num) {
        while(num > 9){
            int sum = 0;
            while(num != 0){
                int prevSum = sum;
                int lastDigit = num%10;
                num = num / 10;
                sum+= lastDigit;
            }
            num = sum;
        }
        return num;
    }
}