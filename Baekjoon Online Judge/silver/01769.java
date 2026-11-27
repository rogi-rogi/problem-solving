import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String X = br.readLine();

        // Solve
        int cnt = 0;
        while (X.length() > 1) {
            int sum = 0;
            for (int i = 0; i < X.length(); ++i) {
                sum += Integer.parseInt(X.charAt(i) + "");
            }
            X = String.valueOf(sum);
            ++cnt;
        }

        // Output
        System.out.println(cnt);
        System.out.println(Integer.parseInt(X) % 3 == 0 ? "YES" : "NO");
    }
}