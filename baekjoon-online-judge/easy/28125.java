import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        HashMap<Character, Character> map = new HashMap<>();
        map.put('@', 'a');
        map.put('[', 'c');
        map.put('!', 'i');
        map.put(';', 'j');
        map.put('^', 'n');
        map.put('0', 'o');
        map.put('7', 't');

        while (T-- > 0) {
            char[] S = br.readLine().toCharArray();

            // Solve
            StringBuilder word = new StringBuilder();
            int cnt = 0;
            for (int i = 0; i < S.length; ++i) {
                if (map.containsKey(S[i])) {
                    word.append(map.get(S[i]));
                    ++cnt;
                } else if (S[i] == '\\') {
                    if (i + 1 < S.length && S[i + 1] == '\'') {
                        word.append('v');
                        ++i;
                        ++cnt;
                    } else if (i + 2 < S.length && S[i + 1] == '\\' && S[i + 2] == '\'') {
                        word.append('w');
                        i += 2;
                        ++cnt;
                    }
                } else {
                    word.append(S[i]);
                }
            }

            if (cnt * 2 >= word.length()) {
                sb.append("I don't understand\n");
            } else {
                sb.append(word).append("\n");
            }
        }

        // Output
        System.out.println(sb);
    }
}