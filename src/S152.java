public class S152 {
    // https://leetcode-cn.com/problems/maximum-product-subarray/description/
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max = nums[0];
        int[][] maxmin = new int[nums.length][2]; // [index][max=0; min=1]

        maxmin[0][0] = nums[0];
        maxmin[0][1] = nums[0];


        for (int i = 1; i < nums.length; i++) {
            int v2 = nums[i] * maxmin[i - 1][0];
            int v3 = nums[i] * maxmin[i - 1][1];

            maxmin[i][0] = max(nums[i], v2, v3);
            maxmin[i][1] = min(nums[i], v2, v3);

            max = Math.max(maxmin[i][0], max);
        }

        return max;
    }

    private int max(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }

    private int min(int num1, int num2, int num3) {
        return Math.min(Math.min(num1, num2), num3);
    }

    public static void main(String[] args) {
        S152 tester = new S152();
        System.out.println(tester.maxProduct(new int[]{2,3,-2,4}));
    }
}
