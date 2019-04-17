import java.util.*;

public class S212 {
    public List<String> findWords(char[][] board, String[] words) {
        S208.Trie trie = new S208.Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> result = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (trie.startsWith("" + c)) {
                    search(trie, board, result, "", i, j);
                }
            }
        }


        return new ArrayList<>(result);
    }

    private void search(S208.Trie trie, char[][] board, Set<String> result,  String word, int row, int column) {
        if (row >= board.length || row < 0) {
            return;
        }
        if (column < 0 || column >= board[row].length) {
            return;
        }
        char c = board[row][column];
        if (c == '.') {
            return;
        }
        String newWord = word + c;
        if (!trie.startsWith(newWord)) {
            return;
        }

        if (trie.search(newWord)) {
            result.add(newWord);
            return;
        }

        board[row][column] = '.';
        search(trie, board, result, newWord, row - 1, column); // up
        search(trie, board, result, newWord, row + 1, column); // down
        search(trie, board, result, newWord, row, column - 1); // left
        search(trie, board, result, newWord, row, column + 1); // right
        board[row][column] = c;
    }

    public static void main(String[] args) {
        char[][] input = {
                new char[]{'a','b'},
                new char[]{'c','d'}
        };

        String[] wordArr = new String[]{"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
        S212 tester = new S212();
        List<String> words = tester.findWords(input, wordArr);

        for (String word : words) {
            System.out.println(word);
        }
    }
}
