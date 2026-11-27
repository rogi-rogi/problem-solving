import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Solve
        int total = 0, notRegistered = 0;
        for (int i = 0; i < N; ++i) {
            if (st.nextToken().equals("0")) {
                notRegistered += A[i];
            }
            total += A[i];
        }

        // Output
        System.out.println(total + "\n" + notRegistered);
    }
}