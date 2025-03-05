import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int a = input[0];
        final int b = input[1];
        final int c = input[2];

        // Solve & Output
        final int sum = Math.abs(a) + Math.abs(b);
        String res = (sum <= c && ((sum % 2 == 0 && c % 2 == 0) || (sum % 2 == 1 && c % 2 == 1))) ? "YES" : "NO";

        // Output
        System.out.println(res);
    }
}