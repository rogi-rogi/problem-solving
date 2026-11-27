import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        int res = 0;
        while (N > 0) {
            int time = 30;
            while (time > 0 && N > 0) {
                final int T = Integer.parseInt(br.readLine());
                if (time / (double) T >= 0.5 || time >= T) {
                    ++res;
                }
                time -= T;
                --N;
            }
        }

        // Output
        System.out.println(res);
    }
}