import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int L, T = 1;
        while ((L = Integer.parseInt(br.readLine().replace(" ",""))) != 0) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 1; i <= N; ++i) {

                // Solve
                sb.append(String.format("User %d\n", T++));
                while (N-- > 0) {
                    double X = Double.parseDouble(br.readLine());
                    X *= L;
                    sb.append(String.format("%.5f\n", X / 100000));
                }
            }
        }

        // Output
        System.out.println(sb);
    }
}