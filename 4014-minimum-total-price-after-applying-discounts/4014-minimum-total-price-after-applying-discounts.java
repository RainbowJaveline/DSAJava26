class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(discounts);
        Arrays.sort(prices);
        double maxi = 0.0f;
        int idx = prices.length-1;
        int i = discounts.length-1;
        while(idx >= 0 && i >= 0){
            double p = prices[idx];
            double d = discounts[i];
            double dis = (p * (100-d)) / 100;
            maxi += dis;
            idx--;
            i--;
        }

        while(idx>= 0){
            maxi+= prices[idx];
            idx--;
        }

        return maxi;
    }
}