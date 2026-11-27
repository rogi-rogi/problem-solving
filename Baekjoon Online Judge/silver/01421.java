import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int C = Integer.parseInt(input[1]);
        final int W = Integer.parseInt(input[2]);

        int[] tree = new int[N];
        int max = 0;
        for (int i = 0; i < N; ++i) {
            tree[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, tree[i]);
        }

        // Solve
        long res = 0;
        for (int h = 1; h <= max; ++h) {
            long price = 0;
            for (int t : tree) {
                final int Q = t / h;
                final int R = t % h;
                final long profit = ((long) Q * h * W) - (long) C * (R > 0 ? Q : Q - 1);
                if (profit > 0) {
                    price += profit;
                }
            }
            res = Math.max(res, price);
        }

        // Output
        System.out.println(res);
    }
}