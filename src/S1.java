import java.util.HashMap;
import java.util.Map;

public class S1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer got = map.get(target - nums[i]);
            if (got != null && got != i) {
                index[0] = i;
                index[1] = got;
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        S1 tester = new S1();
        int[] ints = tester.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
