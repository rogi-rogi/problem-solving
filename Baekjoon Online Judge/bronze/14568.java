import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        int cnt = 0;
        for (int a = 1; a <= N - 2; ++a) { // taqui
            for (int b = 1; b <= N - 2; ++b) { // yeonghun
                for (int c = 1; c <= N - 2; ++c) { // namgyu
                    if (a + b + c != N) continue;
                    if (c < b + 2) continue;
                    if (a % 2 == 1) continue;
                    cnt++;
                }
            }
        }

        // Output
        System.out.println(cnt);
    }
}