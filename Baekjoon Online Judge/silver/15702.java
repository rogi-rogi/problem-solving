import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] score = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxNo = 0, maxScore = -1;
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());

            // Solve
            int sum = 0;
            for (int j = 0; j < N; ++j) {
                if (st.nextToken().equals("O")) {
                    sum += score[j];
                }
            }

            if (sum > maxScore || (sum == maxScore && no < maxNo)) {
                maxScore = sum;
                maxNo = no;
            }
        }

        // Output
        System.out.println(maxNo + " " + maxScore);
    }
}