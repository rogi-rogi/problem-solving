import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());

        // Solve
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int idx = 0;
            while (n > 0) {
                if ((n & 1) == 1)
                    sb.append(idx).append(" ");
                n >>= 1;
                ++idx;
            }
            sb.append("\n");
        }

        // Output
        System.out.println(sb.toString());
    }
}
