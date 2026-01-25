import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int W = Integer.parseInt(in[1]);
        int H = Integer.parseInt(in[2]);

        // Solve
        int max = (int)(Math.sqrt(Math.pow(W, 2) + Math.pow(H, 2)));
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            sb.append(Integer.parseInt(br.readLine()) <= max ? "YES\n" : "NO\n");
        }

        // Output
        System.out.println(sb);
    }
}