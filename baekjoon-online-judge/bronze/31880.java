import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        br.readLine();
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        long result = 0;
        for (int a : A) {
            result += a;
        }
        for (int b : B) {
            if (b > 0) {
                result *= b;
            }
        }

        // Output
        System.out.println(result);
    }
}
