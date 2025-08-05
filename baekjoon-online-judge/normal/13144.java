import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        boolean[] visited = new boolean[(int)1e5 + 1];
        long cnt = 0;
        for (int start = 0, end = 0; start < N; ++start) {
            while (end < N) {
                if (visited[arr[end]]) break;
                visited[arr[end]] = true;
                ++end;
            }
            cnt += (end - start);
            visited[arr[start]] = false;
        }

        // Output
        System.out.println(cnt);
    }
}
