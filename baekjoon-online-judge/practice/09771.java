import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner("\n");

        // Input
        final String S = br.readLine();

        // Solve
        int cnt = 0;

        try {
            while (true) {
                for (String word : br.readLine().split(" ")) {
                    if (word.contains(S)) {
                        ++cnt;
                    }
                }
            }
        } catch (Exception e) {

            // Output
            System.out.println(cnt);
        }
    }
}
