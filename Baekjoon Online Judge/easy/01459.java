import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] position = br.readLine().split(" ");
        final int X = Integer.parseInt(position[0]);
        final int Y = Integer.parseInt(position[1]);
        final int W = Integer.parseInt(position[2]);
        final int S = Integer.parseInt(position[3]);
        
        // Solve
        long res = -1;
        if (2 * W <= S)
            res = (long) (X + Y) * W;
        else {
            int diff = Math.abs(X - Y);
            res = (long) Math.min(X, Y) * S;
            if (W > S) {
                if (diff % 2 == 1) {
                    res += (long) (diff - 1) * S + W;
                } else res += (long) diff * S;
            } else {
                res += (long) diff * W;
            }
        }

        // Output
        System.out.println(res);
    }
}
