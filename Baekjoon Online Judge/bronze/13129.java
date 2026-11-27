import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] in = br.readLine().split(" ");
        int A = Integer.parseInt(in[0]);
        int B = Integer.parseInt(in[1]);
        int N = Integer.parseInt(in[2]);

        // Solve
        StringBuilder sb = new StringBuilder();
        int sum = B + A * N;
        sb.append(sum).append(' ');
        for (int i = 1; i < N; ++i) {
            sb.append(sum + B).append(' ');
            sum += B;
        }

        // Output
        System.out.println(sb);
    }
}