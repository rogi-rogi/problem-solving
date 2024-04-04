import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
      
        final int MAX = 123_456 * 2;
        final boolean NOT_PRIME = false;
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = NOT_PRIME;
        for (int i = 2; i*i <= MAX; ++i) {
            for (int j = i * i; j <= MAX; j+=i) {
                if (isPrime[j]) isPrime[j] = NOT_PRIME;
            }
        }

        // Input
        int N;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            // Solve
            int cnt = 0;
            for (int i = N + 1; i <= 2*N; ++i) {
                if (isPrime[i]) ++cnt;
            }
            sb.append(cnt).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}
