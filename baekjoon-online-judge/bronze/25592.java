import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        int cnt = 1;

        while (true) {
            if (N < cnt) {

                // Output
                System.out.println(cnt % 2 == 1 ? cnt - N : 0);
                break;
            }
            N -= cnt;
            cnt++;
        }
    }
}