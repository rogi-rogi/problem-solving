import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve
        StringBuilder sb = new StringBuilder();
        final int MAX = 2*N;
        for (int i = 1; i < MAX; i += 2) {
            sb.append(i).append(" ");
        }

        // Output
        System.out.println(sb);
    }
}