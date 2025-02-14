import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input & Solve
        while (true) {
            double c = Double.parseDouble(br.readLine());
            if (c == 0.0) break;
            int cnt = 1;
            double len = 0;
            for (int n = 2; ; ++n) {
                len += (1.0/n);
                if (len >= c) {
                    cnt = n - 1;
                    break;
                }
            }
            sb.append(cnt).append(" card(s)\n");
        }

        // Output
        System.out.print(sb);
    }
}
