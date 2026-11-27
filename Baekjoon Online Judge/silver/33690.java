import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve
        int cnt = 1;
        for (int i = 1; i <= 9; i++) {
            long porindrome = i;
            while (porindrome <= N) {
                porindrome = porindrome*10 + i;
                ++cnt;
            }
        }

        // Output
        System.out.println(cnt);
    }
}