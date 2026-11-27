import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        // Solve
        int res = 0;
        for (int num : arr) {
            if (res + 1 < num) break;
            res += num;
        }

        // Output
        System.out.println(res + 1);
    }
}
