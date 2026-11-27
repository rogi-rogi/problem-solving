import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        while (N-- > 0) {
            String str = br.readLine();
            sb.append(String.valueOf(str.charAt(0)).toUpperCase()).append(str.substring(1)).append("\n");
        }

        // Output
        System.out.print(sb);
    }
}
