import java.io.*;

public class Main {
    private static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(br.readLine());
        
        // Solve
        int gcd = 0;
        int[] gcd_list = new int[N - 1];
        for (int i = 0; i < N - 1; ++i) {
            gcd = GCD(gcd, (gcd_list[i] = arr[i + 1] - arr[i]));
        }
        int res = 0;
        for (int num : gcd_list)
            res += num / gcd - 1;

        // Output
        System.out.println(res);
    }
}
