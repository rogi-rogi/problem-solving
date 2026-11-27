import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int TC = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        while (TC-- > 0) {
            String S = br.readLine();
            // Solve
            int cnt = 0;
            for (int i = 0; i < S.length(); ++i) {
                if (set.contains(S.charAt(i))) ++cnt;
            }
            sb.append("The number of vowels in ").append(S).append(" is ").append(cnt).append(".\n");
        }

        // Output
        System.out.println(sb);
    }
}