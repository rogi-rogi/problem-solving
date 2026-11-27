import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Input
        int N = Integer.parseInt(br.readLine());
        
        // Solve
        int[] nums = new int[10];
        for (int digit = 1, hide = 0; N > 0; digit *= 10 ) {
            int R = N % 10;
            N /= 10;
            for (int i = 0; i < R; ++i) nums[i] += (N + 1) * digit;
            for (int i = R; i <= 9; ++i) nums[i] += N * digit;
            nums[R] += 1 + hide;
            nums[0] -= digit;
            hide += R * digit;
        }

        // Output
        for (long num : nums) {
            System.out.print(num + " ");
        }
    }
}
