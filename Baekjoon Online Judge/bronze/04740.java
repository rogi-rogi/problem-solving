import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input & Solve
        while (true) {
            String line = br.readLine();
            if (line.equals("***")) break;
            sb.append((new StringBuilder(line).reverse())).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}
