//121. Best Time to Buy and Sell Stock
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    public int maxProfit(int[] prices) {
        int lowest = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++){ //itterate through array once
        lowest = (prices[i] < lowest) ? prices[i] : lowest; //get current lowest price seen
        profit = (prices[i] - lowest > profit) ? prices[i] - lowest : profit; //see if this offers the most profit available.
        }
    return profit;
    }
}