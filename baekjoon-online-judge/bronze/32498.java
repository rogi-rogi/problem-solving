import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        int res = 0;
        while (N-- > 0) {
            final int D = Integer.parseInt(br.readLine());

            // Solve
            if (D % 2 == 1) ++res;
        }

        // Output
        System.out.println(res);
    }
}
