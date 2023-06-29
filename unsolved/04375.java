import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // init
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String strN;

        // input
        while ((strN = bfr.readLine()) != null && !strN.isEmpty()) {
            int n = Integer.parseInt(strN);
            // solution
            int digit = 1, temp = 1;
            while (temp % n != 0) {
                temp = ((temp * 10) + 1) % n;
                ++digit;
            }
            sb.append(digit).append('\n');
        }

        // output
        System.out.println(sb.toString());
    }
}
