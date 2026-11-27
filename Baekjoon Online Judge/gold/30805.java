import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> res = new ArrayList<>();
    static int N, M;
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        N = Integer.parseInt(br.readLine());
        List<Integer> A = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        M = Integer.parseInt(br.readLine());
        List<Integer> B = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        // Solve
        solve(A, B);

        // Output
        System.out.println(res.size());
        System.out.println(Arrays.toString(res.toArray()).replaceAll("[\\[\\],]",""));
    }
    private static void solve(List<Integer> A, List<Integer> B) {
        if (A.isEmpty() || B.isEmpty()) return;
        int a_max = Collections.max(A);
        int b_max = Collections.max(B);
        int a_max_idx = A.indexOf(a_max);
        int b_max_idx = B.indexOf(b_max);
        if (a_max > b_max) {
            A.remove(a_max_idx);
            solve(A, B);
        } else if (b_max > a_max) {
            B.remove(b_max_idx);
            solve(A, B);
        } else {
            res.add(a_max);
            solve(A.subList(a_max_idx + 1, A.size()), B.subList(b_max_idx + 1, B.size()));
        }
    }
}
