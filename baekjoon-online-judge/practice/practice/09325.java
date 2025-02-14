import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // Input
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            int S = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            int res = S;
            int[] input;
            for (int i = 0; i < N; ++i) {
                input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                // Solve
                res += input[0] * input[1];
            }
            sb.append(res).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}
