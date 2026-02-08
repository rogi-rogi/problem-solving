import java.io.*;

public class Main {
    private static int solve(int N) {
        if (N % 2 == 0 || N % 5 == 0) {
            return -1;
        }
        int likeNum = 0;
        int cnt = 0;
        do {
            likeNum = (10 * likeNum + 1) % N;
            ++cnt;
        } while (likeNum > 0);
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve & Output
        System.out.println(solve(N));
    }
}