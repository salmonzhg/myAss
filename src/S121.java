public class S121 {
    // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int[][] balance = new int[prices.length][2]; // [index][0:buy; 1:sell]
        balance[0][0] = -prices[0];
        balance[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            balance[i][0] = Math.max(balance[i - 1][0], -prices[i]);
            balance[i][1] = Math.max(prices[i] + balance[i - 1][0], balance[i - 1][1]);
        }

        return balance[prices.length - 1][1];
    }

    public static void main(String[] args) {

    }
}
