import java.io.*;
import java.util.*;

public class Main {
    private static void sieveOfEratosthenes(boolean[] isPrime, int N) {
        Arrays.fill(isPrime, true);
        final boolean NOT_PRIME = false;
        isPrime[0] = isPrime[1] = NOT_PRIME;
        for (int p = 2; p * p <= N; ++p) {
            for (int i = p * p; i <= N; i += p) {
                if (isPrime[i]) isPrime[i] = NOT_PRIME;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        // Solve
        final int MAX = 10_000_000;
        boolean[] isPrime = new boolean[MAX + 1];
        sieveOfEratosthenes(isPrime, MAX);

        final int sqrtB = (int)Math.sqrt(B);
        int cnt = 0;
        for (int i = 2 ; i <= sqrtB; ++i) {
            if (isPrime[i]) {
                for (long almostPrime = i; almostPrime <= B/i; almostPrime *= i) {
                    if (almostPrime * i >= A)
                        ++cnt;
                }
            }
        }
        
        // Output
        System.out.println(cnt);
    }
}
