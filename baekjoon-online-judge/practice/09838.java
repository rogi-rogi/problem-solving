import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int N = Integer.parseInt(br.readLine());

        int[] guest = new int[N];
        for (int i = 1; i <= N; ++i) {
            // Solve
            guest[Integer.parseInt(br.readLine()) - 1] = i;
        }

        // Output
        for (int i : guest) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
