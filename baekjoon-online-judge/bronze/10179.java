import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            // Solve
            sb.append(String.format("$%2.2f\n", Double.parseDouble(br.readLine()) * 0.8));
        }

        // Output
        System.out.println(sb);
    }
}
