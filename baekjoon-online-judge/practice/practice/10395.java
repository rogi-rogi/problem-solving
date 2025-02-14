import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int[] X = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] Y = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        String res = "Y";
        for (int i = 0; i < 5; ++i) {
            if (X[i] == Y[i]) {
                res = "N";
                break;
            }
        }

        // Output
        System.out.println(res);
    }
}