import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        String[] input;

        int p1 = 100, p2 = 100, a, b;
        while (N-- > 0) {
            input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);

            // Solve
            if (a > b) {
                p2 -= a;
            } else if (a < b) {
                p1 -= b;
            }
        }

        // Output
        System.out.println(p1 + "\n" +p2);
    }
}
