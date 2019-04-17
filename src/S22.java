import java.util.ArrayList;
import java.util.List;

public class S22 {
    // https://leetcode-cn.com/problems/generate-parentheses/submissions/
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", n, 0, 0);
        return result;
    }

    private void generate(List<String> result, String currentWriting, int n, int leftCount, int rightCount) {
        if (leftCount + rightCount == 2 * n) {
            result.add(currentWriting);
            return;
        }

        // left
        if (leftCount < n) {
            generate(result, currentWriting + "(", n, leftCount + 1, rightCount);
        }
        // right
        if (leftCount > rightCount) {
            generate(result, currentWriting + ")", n, leftCount, rightCount + 1);
        }
    }

    public static void main(String[] args) {
        S22 tester = new S22();
        List<String> strings = tester.generateParenthesis(4);

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
