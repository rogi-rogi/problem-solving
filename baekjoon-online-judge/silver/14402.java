import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String op = st.nextToken();

            if (op.equals("+")) {
                map.put(name, map.getOrDefault(name, 0) + 1);
            } else {
                int cnt = map.getOrDefault(name, 0);
                if (cnt == 0) {
                    ++res;
                } else {
                    map.put(name, cnt - 1);
                }
            }
        }

        for (int cnt : map.values()) {
            res += cnt;
        }

        // Output
        System.out.println(res);
    }
}