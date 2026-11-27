import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer> getPrimeList(int a, int b) {
        boolean[] isPrime = new boolean[b + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        final int sqrtN = (int) Math.sqrt(b);
        for (int i = 2; i <= sqrtN; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j <= b; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= b; ++i) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());
        final int D = Integer.parseInt(st.nextToken());

        // Solve
        List<Integer> primeList = getPrimeList(A, B);
        int cnt = 0;
        for (Integer prime : primeList) {
            if (prime >= A) {
                while (prime > 0) {
                    if (prime % 10 == D) {
                        ++cnt;
                        break;
                    }
                    prime /= 10;
                }
            }
        }

        // Output
        System.out.println(cnt);
    }
}