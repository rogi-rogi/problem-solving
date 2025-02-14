import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
      
        // Input
        int[] nums = new int[3];
        for (int i = 0; i < 3; ++i)
            nums[i] = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        // Solve
        Arrays.sort(nums);
        for (int i = 0; i < 3; ++i)
            sb.append(nums[str.charAt(i) - 'A']).append(" ");

        // Output
        System.out.println(sb.toString());

    }
}
