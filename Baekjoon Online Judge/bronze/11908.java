import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < N - 1; ++i) {
            sum += arr[i];
        }

        // Output
        System.out.println(sum);
    }
}
