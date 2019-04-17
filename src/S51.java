import java.util.*;

public class S51 {
    // https://leetcode-cn.com/problems/n-queens/

    private List<List<String>> results = new ArrayList<>();
    private List<String> board = new ArrayList<>();
    private int n;


    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        Set<Integer> usedColumn = new HashSet<>();
        Set<Integer> usedSlash = new HashSet<>();
        Set<Integer> usedBackslash = new HashSet<>();
        solve(0, usedColumn, usedSlash, usedBackslash);
        return results;
    }

    private void solve(int row,
                       Set<Integer> usedColumn, Set<Integer> usedSlash,
                       Set<Integer> usedBackslash) {
        if (row == n) {
            // copy
            List<String> copied = new ArrayList<>(board);
            results.add(copied);
            return;
        }

        char[] rowCs = new char[n];
        for (int i = 0; i < rowCs.length; i++) {
            rowCs[i] = '.';
        }
        for (int i = 0; i < n; i++) {
            int slashTag = row + i;
            int backslashTag = row - i;
            if (!usedColumn.contains(i) &&
                !usedSlash.contains(slashTag) &&
                !usedBackslash.contains(backslashTag)) {
                // place one
                rowCs[i] = 'Q';
                usedColumn.add(i);
                usedSlash.add(slashTag);
                usedBackslash.add(backslashTag);
                String rowS = new String(rowCs);
                board.add(rowS);

                // next level
                solve(row + 1, usedColumn, usedSlash, usedBackslash);

                // clear
                rowCs[i] = '.';
                board.remove(rowS);
                usedColumn.remove(i);
                usedSlash.remove(slashTag);
                usedBackslash.remove(backslashTag);
            }
        }
    }

    public static void main(String[] args) {
        S51 tester = new S51();
        List<List<String>> lists = tester.solveNQueens(0);

        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }

            System.out.println("====");
        }
    }
}
