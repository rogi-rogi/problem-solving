import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        for (int i = 2; i*i <= N; ++i) {
            while (N % i == 0) {
                sb.append(i).append('\n');
                N /= i;
            }
        }
        if (N > 1) sb.append(N).append('\n');
        
        // Output
        System.out.println(sb);
    }
}
