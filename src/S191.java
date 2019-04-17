public class S191 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        S191 tester = new S191();
        System.out.println(tester.hammingWeight(7));
    }
}
