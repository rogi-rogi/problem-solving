import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = (int)1e6;
    private static List<Integer> getPrimeList() {
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        final int sqrtN = (int) Math.sqrt(MAX);
        for (int i = 2; i <= sqrtN; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= MAX; ++i) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());


        // Solve
        List<Integer> primes = getPrimeList();

//        int[] check = new int[10];
//        for (int k = 2; k <= 9; ++k) {
//            for (Integer prime : primes) {
//                if (prime % k == 1) {
//                    ++check[k];
//                }
//            }
//        }
//        System.out.println(Arrays.toString(check));
        /*
        [0, 0, 78497, 39231, 39175, 19617, 39231, 13063, 19552, 13063]
         */

        int cnt = 0;
        for (Integer prime : primes) {
            if (prime % K == 1) {
                ++cnt;
                sb.append(prime).append(" ");
                if (cnt == N) {
                    break;
                }
            }
        }

        // Output
        System.out.println(sb);
    }
}