import java.io.*;
import java.util.*;

public class Main {
    private static long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; ++i) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int K = Integer.parseInt(input[1]);

        // Solve
        long res = factorial(N) / (factorial(K) * factorial(N - K));

        // Output
        System.out.println(res);
    }
}