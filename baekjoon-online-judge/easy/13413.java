import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            final int N = Integer.parseInt(br.readLine());
            char[] A = br.readLine().toCharArray();
            char[] B = br.readLine().toCharArray();

            // Solve
            int colorDiff = 0;
            int unMatched = 0;
            for (int i = 0; i < N; ++i) {
                if (A[i] == 'W') ++colorDiff;
                if (B[i] == 'W') --colorDiff;
                if (A[i] != B[i]) ++unMatched;
            }
            sb.append(Math.abs(colorDiff) + (unMatched + 1) / 2).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}