import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        List<Integer> R = new ArrayList<>();
        String[] in = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            R.add(Integer.parseInt(in[i]));
        }

        // Solve
        int sum = 0;
        for (int rank = N; rank >= 2; --rank) {
            int lastRankIdx = R.indexOf(rank);

            int minDiff = Integer.MAX_VALUE;
            if (lastRankIdx > 0) {
                minDiff = Math.min(Math.abs(R.get(lastRankIdx - 1) - rank), minDiff);
            }
            if (lastRankIdx < R.size() - 1) {
                minDiff = Math.min(Math.abs(R.get(lastRankIdx + 1) - rank), minDiff);
            }

            sum += minDiff;
            R.remove(lastRankIdx);
        }

        // Output
        System.out.println(sum);
    }
}
