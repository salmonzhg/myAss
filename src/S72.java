public class S72 {
    // https://leetcode-cn.com/problems/edit-distance/

    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        // state
        int[][] distance = new int[w1.length + 1][w2.length + 1];

        // init
        for (int i = 0; i < distance[0].length; i++) {
            distance[0][i] = i;
        }

        for (int i = 0; i < distance.length; i++) {
            distance[i][0] = i;
        }

        // function
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = minOf(
                            distance[i - 1][j - 1] + 1,
                            distance[i - 1][j] + 1,
                            distance[i][j - 1] + 1
                    );
                }
            }
        }

        return distance[word1.length()][word2.length()];
    }

    public int minOf(int n1, int n2, int n3) {
        return Math.min(n3, Math.min(n1, n2));
    }

    public static void main(String[] args) {
        S72 tester = new S72();
        System.out.println(tester.minDistance("horse", "ros"));
    }
}
