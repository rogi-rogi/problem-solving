import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final String[] input = br.readLine().split("\\s+");
        final int A = Integer.parseInt(input[0]);
        final int B = Integer.parseInt(input[1]);

        // Solve & Output
        System.out.println(f(A, B, 0));
    }
    private static int f(int a, int b, int n) {
        if (b == 0) return n - 1;
        return f(b, a % b, n + (a / b));
    }
}
