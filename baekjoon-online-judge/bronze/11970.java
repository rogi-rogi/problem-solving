import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int A = input[0];
        final int B = input[1];
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int C = input[0];
        final int D = input[1];

        // Solve & Output
        System.out.println(C >= B || D <= A  ? B - A + D - C : Math.max(B, D) - Math.min(A, C));
    }
}
