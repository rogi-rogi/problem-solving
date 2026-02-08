import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        // Solve
        final int need = K * (K + 1) / 2;
        int res = -1;
        if (N >= need) {
            res = K + ((N - need) % K == 0 ? -1 : 0);
        }

        // Output
        System.out.println(res);
    }
}