import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String S = br.readLine();

            // Solve
            int idx = 0;
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            do {
                a.append(S.charAt(idx));
                idx = (idx + 2) % S.length();
            } while (idx != 0);
            idx = 1 % S.length();
            if (idx == 0) {
                b.append(S);
            } else {
                do {
                    b.append(S.charAt(idx));
                    idx = (idx + 2) % S.length();
                } while (idx != 1);
            }

            sb.append(a).append("\n");
            sb.append(b).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}