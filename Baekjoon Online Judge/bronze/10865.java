import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cnt = new int[N];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int A = Integer.parseInt(st.nextToken());
            final int B = Integer.parseInt(st.nextToken());

            // Solve
            ++cnt[A - 1];
            ++cnt[B - 1];
        }

        // Output
        System.out.println(Arrays.toString(cnt).replaceAll("[\\[\\]]", "").replaceAll(", ", "\n"));
    }
}