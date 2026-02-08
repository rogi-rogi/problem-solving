import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        int A = Integer.parseInt(st.nextToken());
        final int D = Integer.parseInt(st.nextToken());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int X = 0;
        for (int num : nums) {
            if (num == A) {
                A += D;
                ++X;
            }
        }

        // Output
        System.out.println(X);
    }
}
