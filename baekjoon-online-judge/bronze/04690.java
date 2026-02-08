public class Main {
    public static void main(String[] args)  {
        // Solve
        for (int a = 2; a <= 100; ++a) {
            for (int b = 2; b <= 100; ++b) {
                for (int c = b + 1; c <= 100; ++c) {
                    for (int d = c + 1; d <= 100; ++d) {
                        int lValue = (int) Math.pow(a,3);
                        int rValue = (int) (Math.pow(b,3) + Math.pow(c,3) + Math.pow(d,3));
                        if (lValue == rValue) {
                            // Output
                            System.out.printf("Cube = %d, Triple = (%d,%d,%d)\n", a, b, c, d);
                        } else if (lValue < rValue) break;
                    }
                }
            }
        }
    }
}
