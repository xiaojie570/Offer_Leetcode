public class leetcode_121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE; // 记录数组中的最小值
        int localMax = 0; // 记录如果卖出的话是不是最大的利润，
        for(int price:prices) {
            localMax = Math.max(localMax,price - min);
            min = Math.min(min,price);
        }
        return localMax;
    }
}
