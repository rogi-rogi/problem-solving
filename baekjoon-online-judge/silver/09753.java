import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer> getPrimeList() {
        boolean[] isPrime = new boolean[100001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        final int sqrtN = (int) Math.sqrt(100001);
        for (int i = 2; i <= sqrtN; i++) {
            if (!isPrime[i]) continue;
            for (int j = i + i; j <= 100000; j += i) {
                isPrime[j] = false;
            }
        }
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= 100000; ++i) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }
        return primeList;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T  = Integer.parseInt(br.readLine());
        List<Integer> primeList = getPrimeList();
        while (T-- > 0) {
            final int K = Integer.parseInt(br.readLine());

            // Solve
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < primeList.size(); ++i) {
                for (int j = 0; j < primeList.size(); ++j) {
                    if (i == j) {
                        continue;
                    }
                    final int primeMul = primeList.get(i) * primeList.get(j);
                    if (primeMul >= K) {
                        res = Math.min(res, primeMul);
                        break;
                    }
                }
            }
            sb.append(res).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}