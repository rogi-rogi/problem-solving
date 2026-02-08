import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        br.readLine();
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        Arrays.sort(A);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int a : A) {
            freq.put(a, freq.getOrDefault(a, 0) + 1);
        }
        int maxFreqValue = 0;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            final int val = e.getKey();
            final int count = e.getValue();
            maxFreqValue = Math.max(maxFreqValue, val * count);
        }

        // Output
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.stream(A).sum() + maxFreqValue).append("\n");
        for (int a : A) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}