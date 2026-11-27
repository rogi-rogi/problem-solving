import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<String, String> map = new HashMap<>();
        map.put("063", "0");
        map.put("0", "063");
        map.put("010", "1");
        map.put("1", "010");
        map.put("093", "2");
        map.put("2", "093");
        map.put("079", "3");
        map.put("3", "079");
        map.put("106", "4");
        map.put("4", "106");
        map.put("103", "5");
        map.put("5", "103");
        map.put("119", "6");
        map.put("6", "119");
        map.put("011", "7");
        map.put("7", "011");
        map.put("127", "8");
        map.put("8", "127");
        map.put("107", "9");
        map.put("9", "107");

        // Input
        while (true) {
            String[] p = br.readLine().split("[+|=]");
            if (p[0].equals("BYE"))
                break;

            // Solve
            StringBuilder A = new StringBuilder();
            StringBuilder B = new StringBuilder();
            for (int i = 0; i < p[0].length(); i += 3) {
                A.append(map.get(p[0].substring(i, i + 3)));
            }
            for (int i = 0; i < p[1].length(); i += 3) {
                B.append(map.get(p[1].substring(i, i + 3)));
            }
            String C = String.valueOf(Integer.parseInt(A.toString()) + Integer.parseInt(B.toString()));
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < C.length(); ++i) {
                res.append(map.get(String.valueOf(C.charAt(i))));
            }

            sb.append(p[0]).append("+").append(p[1]).append("=").append(res).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}
