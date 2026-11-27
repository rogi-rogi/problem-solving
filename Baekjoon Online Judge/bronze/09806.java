import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        br.readLine();
        final int P = Integer.parseInt(br.readLine());

        // Solve
        int res = 0;
        for (int num : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
            int temp = (int) Math.pow(num, P);
            if (temp > 0) res += temp;
        }
        
        // Output
        System.out.println(res);
    }
}
