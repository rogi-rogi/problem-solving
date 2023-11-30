import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
      
        // Input
        final int H = Integer.parseInt(br.readLine());

        // Solve
        String res = "";
        if (H == 0) sb.append("1");
        else if (H == 1) sb.append("0");
        else {
            if (H % 2 == 1) sb.append("4");
            sb.append("8".repeat(H/2));
        }

        // Output
        System.out.println(sb);
    }
}
