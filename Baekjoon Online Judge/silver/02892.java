import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        br.readLine();
        Arrays.stream(br.readLine().split(" ")).forEach(
                hex -> {

                    // Solve
                    int dec = Integer.parseInt(hex, 16);
                    sb.append(64 <= dec && dec <= 95 ? "-" : ".");
                }
        );

        // Output
        System.out.println(sb);
    }
}