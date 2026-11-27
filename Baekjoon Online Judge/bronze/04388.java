import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input & Solve
        while (true) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A == 0 && B == 0) break;
            int cnt = 0, onCarry = 0;
            while (A > 0 || B > 0) {
                if (onCarry + (A % 10 + B % 10) >= 10) {
                    ++cnt;
                    onCarry = 1;
                } else onCarry = 0;
                A /= 10;
                B /= 10;
            }
            sb.append(cnt).append("\n");
        }

        // Output
        System.out.print(sb);
    }
}
