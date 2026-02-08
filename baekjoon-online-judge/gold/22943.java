import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> primeList;
    static Set<Integer> primeMulList, primeSumList;
    final static int MAX = 98_765;
    static int res = 0, K, M;
    static boolean[] visited = new boolean[10];
    private static void initPrimeList() {
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);

        isPrime[1] = false;
        final int sqrtN = (int)Math.sqrt(MAX);
        for (int i = 2; i <= sqrtN; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        primeList = new ArrayList<>();
        for (int i = 2; i <= MAX; ++i) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }
    }
    private static void initCheckList() {
        primeMulList = new HashSet<>();
        primeSumList = new HashSet<>();
        for (int p1 = 0; p1 < primeList.size() - 1; ++p1) {
            for (int p2 = p1; p2 < primeList.size(); ++p2) {
                if (p1 != p2) {
                    final int sumTwoPrime = primeList.get(p1) + primeList.get(p2);
                    if (sumTwoPrime <= MAX) {
                        primeSumList.add(sumTwoPrime);
                    }
                }
                final long mulTwoPrime = (long) primeList.get(p1) * primeList.get(p2);
                if (mulTwoPrime <= MAX) {
                    primeMulList.add((int) mulTwoPrime);
                }
            }
        }
    }
    private static void solve(int digit, int num) {
        if (digit == 0) {
            if (primeSumList.contains(num)) {
                while (num % M == 0) {
                    num /= M;
                }
                if (primeMulList.contains(num)) {
                    ++res;
                }
            }
            return;
        }
        for (int i = 0; i <= 9; ++i) {
            if ((i == 0 && digit == K) || visited[i]) continue;
            visited[i] = true;
            solve(digit - 1, num * 10 + i);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        K = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // Solve
        initPrimeList();
        initCheckList();
        solve(K, 0);

        // Output
        System.out.println(res);
    }
}