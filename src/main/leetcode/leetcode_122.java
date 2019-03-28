public class leetcode_122 {
    public int maxProfit(int[] prices) {
        int ret = 0;
        for(int i = 0; i < prices.length - 1;i++) {
            ret += prices[i] < prices[i + 1] ? prices[i + 1] - prices[i] : 0;
        }
        return ret;
    }
}
