import java.io.*;
import java.util.*;

public class Main {
    private static String solve(String[] in) {
        for (String num : in) {
            if (num.equals("!")) {
                return "!";
            }
        }
        int result = 0;
        for (String num : in) {
            result += Integer.parseInt(num);
            if (result > 9) {
                return "!";
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            br.readLine();
            sb.append(solve(br.readLine().split("\\s\\+\\s"))).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}