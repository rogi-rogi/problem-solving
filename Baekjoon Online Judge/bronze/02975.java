import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input & Solve
        while (true) {
            st = new StringTokenizer(br.readLine());
            int balance = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            int diff = Integer.parseInt(st.nextToken());
            if (type.equals("W")) {
                if (balance == 0 && diff == 0) break;
                sb.append(( balance - diff >= -200 ? balance - diff : "Not allowed")).append('\n');
            } else {
                sb.append(balance + diff).append('\n');
            }
        }

        // Output
        System.out.println(sb.toString());
    }
}
