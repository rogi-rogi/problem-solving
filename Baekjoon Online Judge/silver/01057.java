import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        // Solve
        int cnt = 0;
        while (num1 != num2) {
            num1 -= (num1 >> 1);
            num2 -= (num2 >> 1);
            ++cnt;
        }

        // Output
        System.out.println(cnt);
    }
}
