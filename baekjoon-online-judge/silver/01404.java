import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int[][] winProb = new int[8][8];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 7; ++i) {
            for (int j = i + 1; j < 8; ++j) {
                winProb[i][j] = Integer.parseInt(st.nextToken());
                winProb[j][i] = 100 - winProb[i][j];
            }
        }

        // Solve
        double[] quarter = new double[8];
        Arrays.fill(quarter, 1.0);

        for (int i = 0; i < 8; i += 2) {
            quarter[i] *= winProb[i][i + 1] / 100.0;
            quarter[i + 1] *= winProb[i + 1][i] / 100.0;
        }

        double[] semi = new double[8];

        for (int i = 0; i < 8; i += 4) {
            for (int j = 0; j < 4; ++j) {
                int current = i + j;
                for (int k = 0; k < 4; ++k) {
                    if ((k == j) || (k / 2 == j / 2)) continue;
                    int opponent = i + k;
                    semi[current] += quarter[current] * quarter[opponent] * winProb[current][opponent] / 100.0;
                }
            }
        }

        double[] finalProb = new double[8];
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (i / 4 == j / 4) continue;
                finalProb[i] += semi[i] * semi[j] * winProb[i][j] / 100.0;
            }
        }

        // Output
        for (double prob : finalProb) {
            sb.append(prob).append(" ");
        }
        System.out.println(sb);
    }
}