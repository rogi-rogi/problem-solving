import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // Input
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            // Solve
            for (int num = 2; num <= N; ++num) {
                int cnt = 0;
                while (N % num == 0) {
                    ++cnt;
                    N /= num;
                }
                if (cnt > 0) {
                    sb.append(num).append(" ").append(cnt).append("\n");
                }
            }
        }

        // Output
        System.out.println(sb);
    }
}
