import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> startMap = new HashMap<>();
        Map<String, Integer> endMap = new HashMap<>();

        // Input
        for (int i = 0; i < 3; i++) {
            String[] info = br.readLine().split(" ");
            startMap.put(info[0], Integer.parseInt(info[1]));
        }
        for (int i = 0; i < 3; i++) {
            String[] info = br.readLine().split(" ");
            endMap.put(info[0], Integer.parseInt(info[1]));
        }

        String num;
        while (!(num = br.readLine()).equals("-1")) {

            // Solve
            int res = 0;
            for (String subNum : startMap.keySet()) {
                if (num.startsWith(subNum)) {
                    res += startMap.get(subNum);
                }
            }for (String subNum : endMap.keySet()) {
                if (num.endsWith(subNum)) {
                    res += endMap.get(subNum);
                }
            }
            sb.append(res).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}