import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];
        for (int i = 0 ; i < N ; ++i) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // Solve
        for (int i = 0; i < N ; ++i) {
            int temp = 0;
            for (int j = 0 ; j < N ; ++j) {
                temp |= matrix[i][j];
            }
            sb.append(temp).append(" ");
        }

        // Output
        System.out.println(sb);
    }
}