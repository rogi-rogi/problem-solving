import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        final int M = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        // Solve
        String res = "-1";
        int sum = 0;
        for (int i = 1; i <= M; ++i) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            sum += Integer.parseInt(st.nextToken());
            if (sum > K) {
                res = i + " 1";
                break;
            }
        }

        // Output
        System.out.println(res);
    }
}