import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        for (int tc = 1; true; ++tc) {
            char[] perfectWord = br.readLine().toCharArray();
            char[] mixWord = br.readLine().toCharArray();

            // Solve
            boolean isSame = false;
            if (perfectWord.length == mixWord.length) {
                if (perfectWord.length == 3 && perfectWord[0] == 'E' && perfectWord[1] == 'N' && perfectWord[2] == 'D') {
                    break;
                }
                Arrays.sort(perfectWord);
                Arrays.sort(mixWord);

                isSame = true;
                for (int i = 0; i < perfectWord.length; ++i) {
                    if (perfectWord[i] != mixWord[i]) {
                        isSame = false;
                        break;
                    }
                }
            }
            sb.append("Case ").append(tc).append(": ").append(isSame ? "same\n" : "different\n");
        }

        // Output
        System.out.println(sb);
    }
}