import java.io.*;
import java.util.*;

public class Main {
    static long P, Q, X, Y;
    static Map<Long, Long> A;
    private static long getA(long i) {
        if (i <= 0) {
            return 1;
        }
        if (A.containsKey(i)) {
            return A.get(i);
        }
        A.put(i, getA(i / P - X) + getA(i / Q - Y));
        return A.get(i);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final long N = Long.parseLong(input[0]);
        P = Long.parseLong(input[1]);
        Q = Long.parseLong(input[2]);
        X = Long.parseLong(input[3]);
        Y = Long.parseLong(input[4]);

        // Solve
        A = new HashMap<>();
        A.put(0L, 1L);

        // Output
        System.out.println(getA(N));
    }
}