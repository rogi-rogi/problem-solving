import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner("\n");

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            final String S = br.readLine();

            // Solve
            final int size = S.length();
            int sum = 0;
            for (int i = 0; i < size; ++i) {
                sum += S.charAt(i) - '0';
            }
            sum += Integer.parseInt(S.substring(size - 3)) * 10;

            if (sum < 1000) {
                sj.add(String.valueOf(sum + 1000));
            } else {
                String sumStr = String.valueOf(sum);
                int sumStrLen = sumStr.length();
                if (sumStrLen >= 5) {
                    sj.add(sumStr.substring(sumStrLen - 4));
                } else {
                    sj.add(sumStr);
                }
            }
        }

        // Output
        System.out.println(sj);
    }
}
