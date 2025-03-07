import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());

        Pattern pattern = Pattern.compile("^(100+1+|01)+$");
        while (T-- > 0) {
            // Solve
            sb.append(pattern.matcher(br.readLine()).matches() ? "YES\n" : "NO\n");
        }

        // Output
        System.out.println(sb);
    }
}