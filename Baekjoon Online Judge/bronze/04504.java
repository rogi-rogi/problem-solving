import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int n = Integer.parseInt(br.readLine());

        // Solve
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;
            sb.append(num).append(" is").append(num % n == 0 ? "" : " NOT").append(" a multiple of ").append(n).append(".\n");
        }

        // Output
        System.out.print(sb);
    }
}
