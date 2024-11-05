import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner(" ");

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int K = Integer.parseInt(br.readLine());

        // Solve
        int cnt = 2;
        int people = N;
        while ((people >>= 1) >= K) {
            for (int i = 0; i < N; i += cnt) {
                Arrays.sort(A, i, i + cnt);
            }
            cnt <<= 1;
        }

        // Output
        for (int i : A) {
            sj.add(String.valueOf(i));
        }
        System.out.println(sj);
    }
}
