import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        char[] S = br.readLine().toCharArray();

        // Solve
        for (char c : S) {
            int loop = 0;
            int ASCII = c;
            while (ASCII > 0) {
                loop += ASCII % 10;
                ASCII /= 10;
            }
            for (int i = 0; i < loop; i++) {
                sb.append(c);
            }
            sb.append('\n');
        }

        // Output
        System.out.println(sb);
    }
}