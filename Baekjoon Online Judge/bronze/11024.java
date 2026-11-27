import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        while (N-- > 0) {
            sb.append(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum()).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}