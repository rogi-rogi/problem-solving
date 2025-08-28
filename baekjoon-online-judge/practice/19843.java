import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        List<String> days = List.of(new String[]{"Mon", "Tue", "Wed", "Thu", "Fri"});


        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String D1 = st.nextToken();
            int H1 = Integer.parseInt(st.nextToken());
            String D2 = st.nextToken();
            int H2 = Integer.parseInt(st.nextToken());

            // Solve
            if (!D1.equals(D2)) {
                T -= 24 * (days.indexOf(D2) - days.indexOf(D1));
            }
            T -= (H2 - H1);
        }

        if (T > 48) {
            T = -1;
        } else if (T < 0 && T > - 49) {
            T = 0;
        }

        // Output
        System.out.println(T);
    }
}