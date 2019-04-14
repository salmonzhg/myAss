import java.util.Comparator;
import java.util.PriorityQueue;

public class S703 {
    private static class KthLargest {

        private int k;
        private PriorityQueue<Integer> queue;

        public KthLargest(int k, int[] nums) {
            if (k < 1) {
                throw new RuntimeException();
            }
            this.k = k;
            this.queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            queue.add(val);
            if (queue.size() == k + 1) {
                queue.poll();
            }
            return queue.peek();
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(10));   // returns 4
        System.out.println(kthLargest.add(9));   // returns 4
        System.out.println(kthLargest.add(4));   // returns 4
    }
}
