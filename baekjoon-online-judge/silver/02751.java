import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // Solve
        Arrays.sort(A);

        // Output
        for (int num : A) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}