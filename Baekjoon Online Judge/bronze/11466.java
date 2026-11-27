import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        st = new StringTokenizer(br.readLine());
        double H = Double.parseDouble(st.nextToken());
        double W = Double.parseDouble(st.nextToken());

        // Solve
        if (W > H) {
            double temp = W;
            W = H;
            H = temp;
        }

        // Output
        System.out.printf("%.6f", Math.max(Math.min(W, H / 3), Math.min(W / 2, H / 2)));
    }
}