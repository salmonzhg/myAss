import java.util.List;

public class S120 {
    // https://leetcode-cn.com/problems/triangle/description/
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowCount = triangle.size();
        if (rowCount == 0) return 0;
        if (rowCount == 1) {
            if (triangle.get(0).size() == 0) {
                return 0;
            } else {
                return triangle.get(0).get(0);
            }
        }

        for (int i = rowCount - 2; i >= 0; i--) {
            List<Integer> curRow = triangle.get(i);
            List<Integer> nextRow = triangle.get(i + 1);
            int rowSize = curRow.size();

            for (int j = 0; j < rowSize; j++) {
                curRow.set(j, curRow.get(j) + Math.min(nextRow.get(j), nextRow.get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {

    }
}
