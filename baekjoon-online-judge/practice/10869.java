import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        // Input
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        final int A = input[0];
        final int B = input[1];

        // Output
        System.out.printf("%d\n%d\n%d\n%d\n%d\n", A + B, A - B, A * B, A / B, A % B);
    }
}
