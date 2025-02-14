import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // Input
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());
        final int D = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        // Solve & Output
        while (st.hasMoreTokens()) {
            int cnt = 0;
            int t = Integer.parseInt(st.nextToken());
            int first = t % (A + B);
            int second = t % (C + D);
            if (0 < first && first <= A) ++cnt;
            if (0 < second && second <= C) ++cnt;

            System.out.println(cnt);
        }
    }
}
