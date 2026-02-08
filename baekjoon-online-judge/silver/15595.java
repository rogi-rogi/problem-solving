import java.io.*;
import java.util.*;

public class Main {
    static String SUCCESS = "4", ADMIN = "megalusion";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // Input
        int N = Integer.parseInt(br.readLine());

        Map<String, Boolean> solved = new HashMap<>();
        Map<String, Integer> wrongCnt = new HashMap<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String name = st.nextToken();
            int res = Integer.parseInt(st.nextToken());

            // Solve
            if (name.equals(ADMIN) || solved.getOrDefault(name, false)) continue;
            wrongCnt.putIfAbsent(name, 0);
            if (res == 4) {
                solved.put(name, true);
            } else {
                wrongCnt.put(name, wrongCnt.get(name) + 1);
            }
        }

        int solvedCnt = 0;
        int totalWrongCnt = 0;
        for (String user : solved.keySet()) {
            if (solved.get(user)) {
                solvedCnt++;
                totalWrongCnt += wrongCnt.getOrDefault(user, 0);
            }
        }
        double res = 0;
        if (solvedCnt != 0) {
            res = ((double) solvedCnt / (solvedCnt + totalWrongCnt)) * 100;
        }

        // Output
        System.out.println(res);
    }
}