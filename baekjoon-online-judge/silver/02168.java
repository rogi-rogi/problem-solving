import java.io.*;

public class Main {
    private static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int X = Integer.parseInt(input[0]);
        final int Y = Integer.parseInt(input[1]);

        // Solve & Output
        final int gcd = GCD(X, Y);
		System.out.println(X + Y - gcd);
    }
}