import java.util.HashMap;
import java.util.Map;

public class S208 {
    static class Trie {
        private char val;
        private boolean end = false;
        private Map<Character, Trie> children = new HashMap<>();

        /** Initialize your data structure here. */
        public Trie() {

        }

        private Trie(char val) {
            this.val = val;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word.length() == 0) return;
            insertInternal(word.toCharArray(), 0);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (word.length() == 0) return false;
            return searchInternal(word.toCharArray(), 0);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if (prefix.length() == 0) return false;
            return startsWithInternal(prefix.toCharArray(), 0);
        }

        private boolean searchInternal(char[] word, int index) {
            char c = word[index];
            Trie child = children.get(c);
            if (child != null) {
                if (index == word.length - 1) {
                    return child.end;
                }
                return child.searchInternal(word, index + 1);
            } else {
                return false;
            }
        }

        private boolean startsWithInternal(char[] prefix, int index) {
            char c = prefix[index];
            Trie child = children.get(c);
            if (child != null) {
                if (index == prefix.length - 1) {
                    return true;
                }
                return child.startsWithInternal(prefix, index + 1);
            } else {
                return false;
            }
        }

        private void insertInternal(char[] word, int index) {
            char c = word[index];
            Trie child = children.get(c);
            if (child == null) {
                child = new Trie(c);
                children.put(c, child);
            }
            if (index == word.length - 1) {
                child.end = true;
                return;
            }
            child.insertInternal(word, index + 1);
        }
    }


    public static void main(String[] args) {
        Trie root = new Trie();
        root.insert("hello");

        System.out.println(root.search("hello"));
    }
}
