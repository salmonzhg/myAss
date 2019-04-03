public class S322 {
    // https://leetcode-cn.com/problems/coin-change/

    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins.length == 0) return 0;
        int[] change = new int[amount+1];

        for (int i = 1; i <=amount; i++) {
            change[i] = amount+1;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    change[i] = Math.min(change[i], change[i-coins[j]] + 1);
                }
            }
        }

        return change[amount] > amount ? -1 : change[amount];
    }

    public static void main(String[] args) {
        S322 tester = new S322();
        System.out.println(tester.coinChange(new int[]{1, 2, 5}, 11));
    }
}
