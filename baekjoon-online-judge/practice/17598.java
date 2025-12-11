import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int T = 9;
        int cnt = 0;
        while (T-- > 0) {
            // Solve
            if (br.readLine().equals("Lion")) {
                ++cnt;
            }
        }

        // Output
        System.out.println(cnt >= 5 ? "Lion" : "Tiger");
    }
}