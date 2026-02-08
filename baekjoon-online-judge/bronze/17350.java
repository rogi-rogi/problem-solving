import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            // Solve
            if (br.readLine().equals("anj")) {
                sb.append("뭐야;");
                break;
            }
        }
        if (sb.isEmpty()) {
            sb.append("뭐야?");
        }

        // Output
        System.out.println(sb);
    }
}