public class S123 {
    // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int[][][] balance = new int[prices.length][2][3]; // [index][hold state][transaction index]

        balance[0][1][0] = - prices[0];
        balance[0][1][1] = Integer.MIN_VALUE;
        balance[0][1][2] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            balance[i][1][0] = Math.max(- prices[i], balance[i - 1][1][0]);

            balance[i][1][1] = Math.max(balance[i - 1][0][1] - prices[i], balance[i - 1][1][1]);
            balance[i][0][1] = Math.max(prices[i] + balance[i - 1][1][0], balance[i - 1][0][1]);

            balance[i][0][2] = Math.max(prices[i] + balance[i - 1][1][1], balance[i - 1][0][2]);
        }

        return Math.max(Math.max(balance[prices.length - 1][0][2], balance[prices.length - 1][0][1]),
                balance[prices.length - 1][0][0]);
    }

    public static void main(String[] args) {
        S123 tester = new S123();
        System.out.println(tester.maxProfit(new int[]{1,2,3,4,5}));
    }
}
