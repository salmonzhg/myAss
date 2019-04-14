import java.util.Arrays;
import java.util.Stack;

public class QSort {

    public void sort(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return;
        }

        Stack<CalUnit> calUnits = new Stack<>();
        calUnits.push(new CalUnit(nums, 0, length - 1));
        while (!calUnits.isEmpty()) {
            CalUnit unit = calUnits.pop();
            if (unit.start >= unit.end) {
                continue;
            }
            int mid = partition(unit);

            calUnits.push(new CalUnit(nums, unit.start, mid - 1));
            calUnits.push(new CalUnit(nums, mid + 1, unit.end));
        }
    }

    class CalUnit {
        int[] nums;
        int start;
        int end;

        public CalUnit(int[] nums, int start, int end) {
            this.nums = nums;
            this.start = start;
            this.end = end;
        }
    }

    public int partition(CalUnit unit) {
        return partition(unit.nums, unit.start, unit.end);
    }

    public int partition(int[] nums, int start, int end) {
        int low = start;
        int high = end;

        // operation
        int base = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= base) {
                high --;
            }

            swap(nums, low, high);

            while (low < high && nums[low] < base) {
                low ++;
            }

            swap(nums, low, high);
        }
        nums[low] = base;
        return low;
    }

    public void swap(int[] nums, int index1, int index2) {
        int dummy = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = dummy;
    }

    public static void main(String[] args) {
        QSort sorter = new QSort();
        int[] as = new int[]{3,1,2,9,4,0,7,-2,8,10,10,12};

        sorter.sort(as);

        for (int i = 0; i < as.length; i++) {
            System.out.print(as[i] + " | ");
        }
    }
}
