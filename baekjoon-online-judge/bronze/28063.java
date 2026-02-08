import java.io.*;
import java.util.*;

public class Main {
    private static int solve(int X, int Y, int N) {
        int res = 4;
        if (N == 1) {
            res = 0;
        } else if ((X == 1 && Y == 1) ||
                (X == N && Y == 1) ||
                (X == 1 && Y == N) ||
                (X == N && Y == N)
        ) {
            res = 2;
        } else if (X == 1 || Y == 1 || X == N || Y == N) {
            res = 3;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        final int X = Integer.parseInt(st.nextToken());
        final int Y = Integer.parseInt(st.nextToken());

        // Solve & Output
        System.out.println(solve(X, Y, N));
    }
}