import java.io.*;
import java.util.*;


public class Main {
    private static ArrayList<Integer> sieveOfEratosthenes(boolean[] isPrime, int N) {
        final boolean NOT_PRIME = false;
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = NOT_PRIME;
        for (int p = 2; p * p <= N; ++p) {
            for (int i = p * p; i <= N; i += p) {
                if (isPrime[i]) isPrime[i] = NOT_PRIME;
            }
        }
        ArrayList<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= N; ++i) {
            if (isPrime[i])
                primeList.add(i);
        }
        return primeList;
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());

        // Solve
        final int MAX = 1_000_000;

        boolean[] isPrime = new boolean[MAX + 1];
        ArrayList<Integer> primeList = sieveOfEratosthenes(isPrime, MAX);
        int N, cnt;
        while (T-- > 0) {
            cnt = 0;
            N = Integer.parseInt(br.readLine());
            for (Integer prime : primeList) {
                if (prime > N / 2) break;
                if (isPrime[N - prime]) ++cnt;
            }
            sb.append(cnt).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}
