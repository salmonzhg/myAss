import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class S239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || k > nums.length) {
            return new int[]{};
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // init
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        int endIndex = nums.length - k + 1;
        int[] result = new int[endIndex];
        result[0] = queue.peek();
        for (int start = 1, end = k ; start < endIndex; start++, end++) {
            int outIndex = start - 1;
            queue.remove(nums[outIndex]);
            queue.add(nums[end]);
            result[start] = queue.peek();
        }

        return result;
    }

    public static void main(String[] args) {
        S239 tester = new S239();
        int[] ints = tester.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
