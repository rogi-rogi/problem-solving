import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Input
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int K = Integer.parseInt(input[1]);
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // Solve
        int cnt = 0;
        for (int i = 0; i < N - 1; ++i) {
            if (arr[i] - arr[i + 1] >= K) ++cnt;
        }

        // Output
        System.out.println(cnt);
    }
}
