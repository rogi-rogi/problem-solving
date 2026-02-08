import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());
        List<String[]> list = new ArrayList<>();
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            list.add(new String[]{input[0], input[1]});
        }

        // Solve
        list.sort((s1, s2) -> {
            int cmp = s1[0].compareTo(s2[0]);
            if (cmp == 0) {
                return -s1[1].compareTo(s2[1]);
            }
            return cmp;
        });

        // Output
        for (String[] s : list) {
            sb.append(s[0]).append(" ").append(s[1]).append("\n");
        }
        System.out.println(sb);
    }
}