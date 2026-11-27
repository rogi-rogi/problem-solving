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
            }
            int colorDiffCopy = Math.abs(colorDiff);
            for (int i = 0; i < N; ++i) {
                if (A[i] != B[i]) {
                    if (colorDiffCopy > 0) {
                        --colorDiffCopy;
                    } else {
                        ++unMatched;
                    }
                }
            }

            sb.append(Math.abs(colorDiff) + unMatched / 2).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}