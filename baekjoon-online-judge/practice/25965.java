import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            final int M = Integer.parseInt(br.readLine());
            List<long[]> missionList = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                missionList.add(Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray());
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int K = Integer.parseInt(st.nextToken());
            final int D = Integer.parseInt(st.nextToken());
            final int A = Integer.parseInt(st.nextToken());

            long sum = 0;
            // Solve
            for (long[] mission : missionList) {
                final long donation = K*mission[0] - D*mission[1] + A*mission[2];
                if (donation > 0) {
                    sum += donation;
                }
            }
            sb.append(sum).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}