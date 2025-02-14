import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Input
        int[] nums = new int[3];
        for (int i = 0; i < 3; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // Solve
        Arrays.sort(nums);

        int diff1 = nums[1] - nums[0];
        int diff2 = nums[2] - nums[1];
        int res = nums[2] + diff1;
        if (diff1 < diff2) res = nums[1] + diff1;
        if (diff1 > diff2) res = nums[0] + diff2;

        // Output
        System.out.println(res);
    }
}
