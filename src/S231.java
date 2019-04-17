public class S231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        S231 tester = new S231();
        System.out.println(tester.isPowerOfTwo(16));
    }
}
