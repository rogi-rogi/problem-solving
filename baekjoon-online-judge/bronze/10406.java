import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        st = new StringTokenizer(br.readLine());
        final int W = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());
        int[] H = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int cnt = 0;
        for (int h : H) {
            if (W <= h && h <= N)
                ++cnt;
        }

        // Output
        System.out.println(cnt);
    }
}
