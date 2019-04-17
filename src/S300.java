import java.util.LinkedList;

public class S300 {
    // https://leetcode-cn.com/problems/longest-increasing-subsequence/

    // o(n*n)
    public int lengthOfLIS1(int[] nums) {
        if(nums.length == 0) return 0;
        int[] lts = new int[nums.length];
        for (int i = 0; i < lts.length; i++) {
            lts[i] = 1;
        }

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = 0; j < i; j++) {
                if (cur > nums[j]) {
                    lts[i] = Math.max(lts[i], lts[j] + 1);
                }
                max = Math.max(lts[i], max);
            }
        }

        return max;
    }

    // o(nlogn)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        LinkedList<Integer> result = new LinkedList<>();
        result.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur <= result.getFirst()) {
                result.set(0, cur);
            } else if (cur > result.getLast()) {
                result.add(cur);
            } else {
                binaryInseat(result, cur);
            }
        }

        return result.size();
    }

    private void binaryInseat(LinkedList<Integer> data, int target) {
        int end = data.size() - 1;
        int start = 0;
        int mid = (end - start) / 2;

        while (mid > start && mid < end) {
            if (target > data.get(mid)) {
                start = mid;
            } else {
                end = mid;
            }
            mid = start + (end - start) / 2;
        }

        int insertIndex = mid + 1;
        data.set(insertIndex, target);
    }

    public static void main(String[] args) {
        S300 tester = new S300();

        System.out.println(tester.lengthOfLIS1(new int[]{10,9,2,5,3,7,101,18}));
    }
}
