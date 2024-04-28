import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] op;

    private static void permutation(int[] arr, int res, int cnt) {
        if (cnt == N) {
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }
        for (int i = 0; i < 4; ++i) {
            if (op[i] > 0) {
                --op[i];
                switch (i) {
                    case 0:
                        permutation(arr,res + arr[cnt],cnt + 1);
                        break;
                    case 1:
                        permutation(arr,res - arr[cnt],cnt + 1);
                        break;
                    case 2:
                        permutation(arr,res * arr[cnt],cnt + 1);
                        break;
                    case 3:
                        permutation(arr,res / arr[cnt],cnt + 1);
                        break;
                }
                ++op[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        op = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        permutation(arr, arr[0], 1);

        // Output
        System.out.println(max + "\n" + min);
    }
}
