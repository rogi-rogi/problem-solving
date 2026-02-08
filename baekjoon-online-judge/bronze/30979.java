import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int T = Integer.parseInt(br.readLine());
        br.readLine();
        final int fSum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();

        // Solve & Output
        System.out.println(T <= fSum ? "Padaeng_i Happy" : "Padaeng_i Cry");
    }
}