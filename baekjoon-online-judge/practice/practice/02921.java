import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve
        int sum = N * (N + 1) * (N + 2) / 3;

        // Output
        System.out.println((int)(1.5 * sum));
    }
}
