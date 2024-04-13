import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        int e = 1;
        long res = 0;
        while (e <= N) {
            res += N - (e - 1);
            e *= 10;
        }

        // Output
        System.out.println(res);
    }
};
