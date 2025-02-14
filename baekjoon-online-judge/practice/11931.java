import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            nums.add(Integer.parseInt(br.readLine()));
        }

        // Solve
        nums.sort(Collections.reverseOrder());

        // Output
        System.out.println(nums.toString().replaceAll("[\\[\\]]", "").replaceAll(", ", "\n"));
    }
}
