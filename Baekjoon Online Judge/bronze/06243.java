import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        int res = 0;
        while (true) {
            st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            if (first.equals("0")) {
                sb.append(res).append('\n');
                res = 0;
                continue;
            } else if (first.equals("#")) {
                break;
            }

            // Solve
            st.nextToken();
            int distance = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            switch (type) {
                case "F":
                    res += distance * 2;
                    break;
                case "B":
                    res += distance + (distance + 1) / 2;
                    break;
                default:
                    res += Math.max(distance, 500);
            }
        }

        // Output
        System.out.println(sb);
    }
}