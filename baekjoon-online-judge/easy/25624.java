import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static boolean solve(Set<Character>[] set, String[] input) {
        Set<String> words = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            set[i] = new HashSet<>();
        }

        for (String s : input) {
            if (!words.add(s)) {
                return false;
            }
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < j; ++k) {
                    if (set[k].contains(s.charAt(j))) {
                        return false;
                    }
                }
                set[j].add(s.charAt(j));
            }
        }

        int res = 1;
        for (Set<Character> word : set) {
            res *= word.size();
        }
        if (res != M) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] input = new String[M];
        for (int i = 0; i < M; ++i) {
            input[i] = br.readLine();
        }

        // Solve
        Set<Character>[] set = new Set[N];
        if (solve(set, input)) {
            // Output
            StringBuilder sb = new StringBuilder();
            sb.append("YES\n");
            for (Set<Character> word : set) {
                List<Character> list = new ArrayList<>(word);
                Collections.sort(list);
                for (char c : list) sb.append(c);
                sb.append("\n");
            }
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}