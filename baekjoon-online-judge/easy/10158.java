import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        st = new StringTokenizer(br.readLine());
        final int W = Integer.parseInt(st.nextToken());
        final int H = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        final int T = Integer.parseInt(br.readLine());

        // Solve
        int nx = (X + T) % W;
        nx = ((X + T) / W) % 2 == 1 ? W - nx : nx;
        int ny = (Y + T) % H;
        ny = ((Y + T) / H) % 2 == 1 ? H - ny : ny;

        // Output
        System.out.println(nx + " " + ny);
    }
}