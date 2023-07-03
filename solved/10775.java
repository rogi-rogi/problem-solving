import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // init
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        // input
        int G = Integer.parseInt(bfr.readLine());
        int P = Integer.parseInt(bfr.readLine());
        int[] jump = new int[G + 1];
        Arrays.fill(jump, 0);
        int cnt = 0;
        boolean shutdown = false;
        while (P-- > 0 && !shutdown) {
            int g = Integer.parseInt(bfr.readLine());
            // solution
            while (g > 0 && jump[g] > 0) {
                int temp = jump[g];
                ++jump[g];
                g -= temp;
            }
            if (g > 0) {
                jump[g] = 1;
                ++cnt;
            } else shutdown = true;
        }

        // output
        System.out.println(cnt);
    }
}
