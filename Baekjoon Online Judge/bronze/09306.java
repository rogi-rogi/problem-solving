import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int N = Integer.parseInt(br.readLine());
        String first, second;
        for (int i = 1; i <= N; ++i) {
            // Solve
            first = br.readLine();
            second = br.readLine();
            sb.append(String.format("Case %d: %s, %s\n", i, second, first));
        }

        // Output
        System.out.println(sb);
    }
}
