import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] A = new int[10];

        // Input
        int N = Integer.parseInt(br.readLine());


        for(int i = 1; i <= 10; i++) {
            A[i-1] = ((i - 1) % 5) + 1;
        }

        // Solve
        for(int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());

            int cnt = 0;
            for (int j = 0; j < 10; ++j) {
                if (Integer.parseInt(st.nextToken()) == A[j]) {
                    ++cnt;
                }
            }

            if(cnt == 10) {
                sb.append(i).append("\n");
            }
        }

        // Output
        System.out.print(sb);
    }
}
