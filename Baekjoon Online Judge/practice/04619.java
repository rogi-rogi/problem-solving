import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input

        while (true) {
            st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if (B == 0 && N == 0) break;
            int A = 0;
            while (Math.pow(A,N) < B) {
                ++A;
            }
            if (B - Math.pow(A-1, N) < Math.pow(A, N) - B) sb.append(A - 1).append("\n");
            else sb.append(A).append("\n");
        }

        // Output
        System.out.print(sb);
    }
}
