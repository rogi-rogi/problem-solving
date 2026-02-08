import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int A = Integer.parseInt(input[0]);
        final int B = Integer.parseInt(input[1]);
        final int C = Integer.parseInt(input[2]);
        final int X = Integer.parseInt(input[3]);
        final int Y = Integer.parseInt(input[4]);

        // Solve
        int money = 0;
        if (A + B < 2 * C) {
            money = A * X + B * Y;
        } else {
            money += 2 * C * Math.min(X, Y);
            if (X - Y > 0)
                money += (X - Y) * Math.min(A, 2 * C);
            if (Y - X > 0)
                money += (Y - X) * Math.min(B, 2 * C);
        }

        // Output
        System.out.println(money);
    }
}
