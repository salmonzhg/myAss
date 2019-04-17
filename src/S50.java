public class S50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }

        if (n % 2 == 0) {
            double v = myPow(x, n / 2);
            return v * v;
        } else {
            double v = myPow(x, n / 2);
            int oneMoreN = n > 0 ? 1 : -1;
            return v * v * myPow(x, oneMoreN);
        }
    }

    public static void main(String[] args) {
        S50 tester = new S50();
        System.out.println(tester.myPow(2.0, -4));
    }
}
