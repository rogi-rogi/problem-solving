import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; ++i) {
            map.merge(br.readLine(), 1, (cur, _init) -> cur + 1);
        }
        for (int i = 1; i < N; ++i) {
            map.computeIfPresent(br.readLine(), (_key, cur) ->
                cur - 1 == 0 ? null : cur - 1);
        }

        // Output
        System.out.println(map.keySet().toString().replaceAll("[\\[\\]]", ""));
    }
}