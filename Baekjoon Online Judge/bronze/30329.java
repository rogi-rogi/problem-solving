import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String line = br.readLine();

        // Solve
        int cnt = 0;
        for (int i = 0; i + 3 < line.length(); ++i) {
            if (line.substring(i, i + 4).equals("kick")) {
                ++cnt;
            }
        }

        // Output
        System.out.println(cnt);
    }
}
