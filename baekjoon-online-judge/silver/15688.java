import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // Input
        final int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // Solve
        Arrays.sort(nums);
        for (int num : nums) {
            sb.append(num).append("\n");
        }
        
        // Output
        System.out.println(sb);
    }
}
