import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        
        // Solve
        for (int tc = 1; tc <= T; ++tc) {
            String[] input = br.readLine().split(" ");
            final int A = Integer.parseInt(input[0]);
            final int B = Integer.parseInt(input[1]);
            sb.append("Case ").append(tc).append(": ").append(A + B).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}
