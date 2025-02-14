import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Input
        int[] nums = new int[10];
        for (int i = 0; i < 10; ++i)
            nums[i] = Integer.parseInt(st.nextToken());

        // Solve
        int res = 0;
        for (int i = 0; i < 9; ++i) {
            for (int j = i + 1; j < 10; ++j)
                res ^= (nums[i] | nums[j]);
        }
        for (int i = 0; i < 8; ++i) {
            for (int j = i + 1; j < 9; ++j)
                for (int k = j + 1; k < 10; ++k)
                    res ^= (nums[i] | nums[j] | nums[k]);
        }

        // Output
        System.out.println(res);
    }
}
