import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        int res = 0;
        while (N-- > 0) {
            final int P = Integer.parseInt(br.readLine());
            res += (int) Math.pow(P / 10, P % 10);
        }

        // Output
        System.out.println(res);
    }
}