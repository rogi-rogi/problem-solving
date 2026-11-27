import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int L = Integer.parseInt(st.nextToken());
        int time = 0, cur = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            final int D = Integer.parseInt(st.nextToken());
            final int R = Integer.parseInt(st.nextToken());
            final int G = Integer.parseInt(st.nextToken());
            time += (D - cur);
            time += Math.max(0, R - time % (R + G));
            cur = D;
        }
        time += L - cur;

        // Output
        System.out.println(time);
    }
}