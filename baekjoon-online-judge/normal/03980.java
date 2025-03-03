import java.io.*;
import java.util.*;

public class Main {
    static int[][] A;
    static boolean[] visited;
    private static int bt(int sum, int i) {
        if (i == 11) {
            return sum;
        }
        int res = 0;
        for (int j = 0; j < 11; ++j) {
            if (!visited[j] && A[i][j] > 0) {
                visited[j] = true;
                res = Math.max(res, bt(sum + A[i][j], i + 1));
                visited[j] = false;
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            A = new int[11][];
            visited = new boolean[11];
            for (int i = 0; i < 11; ++i) {
                A[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            sb.append(bt(0, 0)).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}
