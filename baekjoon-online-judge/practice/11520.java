import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            // Solve
            sb.append(Integer.parseInt(br.readLine().split(" ")[1])).append(" ").append(5).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}