import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] info = br.readLine().split(" ");
        final int M = Integer.parseInt(info[0]);
        final int N = Integer.parseInt(info[1]);
        int[][] arr = new int[M][];

        // Solve
        for (int i = 0; i < M; ++i) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] sorted = Arrays.stream(arr[i]).distinct().sorted().toArray();
            for (int j = 0; j < N; ++j)
                arr[i][j] = Arrays.binarySearch(sorted, arr[i][j]);
        }
        int res = 0;
        for (int i = 0; i < M; ++i) {
            for (int j = i + 1; j < M; ++j)
                if (Arrays.equals(arr[i], arr[j])) res ++;
        }

        // Output
        System.out.println(res);
    }
}
