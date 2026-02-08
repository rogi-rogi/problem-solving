import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        // Solve
        while (N-- > 0) {
            sb.append(S);
        }

        // Output
        System.out.println(sb);
    }
}