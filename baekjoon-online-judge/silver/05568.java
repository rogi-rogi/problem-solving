import java.io.*;
import java.util.*;

public class Main {
    static Set<String> set;
    static boolean[] visited;
    static String[] A;
    static int N, K;
    private static void permutations(List<String> permutation) {
        if (permutation.size() == K) {
            StringBuilder sb = new StringBuilder();
            for (String num : permutation) {
                sb.append(num);
            }
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < N; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                permutation.add(A[i]);
                permutations(permutation);
                permutation.remove(permutation.size() - 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }
        set = new HashSet<>();
        visited = new boolean[N];

        // Solve
        permutations(new ArrayList<>());

        // Output
        System.out.println(set.size());
    }
}