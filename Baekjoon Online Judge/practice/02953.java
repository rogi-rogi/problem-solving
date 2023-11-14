import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input

        // Input & Solve
        int maxSum = 0, idx = 0;
        for (int i = 1; i <= 5; ++i) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < 4; ++j)
                sum += Integer.parseInt(st.nextToken());
            if (sum > maxSum) {
                maxSum = sum;
                idx = i;
            }
        }

        // Output
        System.out.println(idx + " " + maxSum);
    }
}
