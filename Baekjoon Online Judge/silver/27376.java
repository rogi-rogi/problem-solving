import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int K = Integer.parseInt(input[1]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < K; ++i) {
            input = br.readLine().split(" ");
            final int x = Integer.parseInt(input[0]);
            final int t = Integer.parseInt(input[1]);
            final int s = Integer.parseInt(input[2]);
            list.add(new int[]{x, t, s});
        }
        list.sort(Comparator.comparingInt(a -> a[0]));

        long time = 0, lastPos = 0;
        for (int[] info : list) {
            final int x = info[0];
            final int t = info[1];
            final int s = info[2];
            time += x - lastPos;
            if (s > time) {
                time += s - time;
            } else {
                final long diff = time - s;
                final boolean enableRed = (diff / t) % 2 == 1;
                time += enableRed ? t - diff % t : 0;
            }
            lastPos = x;
        }
        time += N - lastPos;

        // Output
        System.out.println(time);
    }
}