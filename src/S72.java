public class S72 {
    // https://leetcode-cn.com/problems/edit-distance/

    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        char[] w1s = word1.toCharArray();
        char[] w2s = word2.toCharArray();

        int[][] distance = new int[length1 + 1][length2 + 1];

        for (int i = 0; i < length1 + 1; i++) {
            distance[i][0] = i;
        }

        for (int i = 0; i < length2 + 1; i++) {
            distance[0][i] = i;
        }

        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                if (w1s[i - 1] == w2s[j - 1]) {
                    distance[i][j] = distance[i-1][j-1];
                } else {
                    distance[i][j] = minOf(
                            distance[i-1][j-1] + 1, // 替换
                            distance[i][j-1] + 1, //
                            distance[i-1][j] + 1
                    );

                }
            }
        }

        return distance[length1][length2];
    }

    public int minOf(int n1, int n2, int n3) {
        return Math.min(n3, Math.min(n1, n2));
    }

    public static void main(String[] args) {
        S72 tester = new S72();
        System.out.println(tester.minDistance("horse", "ros"));
    }
}
