import java.io.*;
import java.util.*;

public class Main {
    static char[] nums;
    private static boolean check(int L, int R) {
        final int MID = (L + R) >> 1;
        int sum = 0;
        for (int j = L; j < MID; ++j) {
            sum += nums[j] - '0';
        }
        for (int j = MID; j < R; ++j) {
            sum -= nums[j] - '0';
        }
        return sum == 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        nums = br.readLine().toCharArray();

        // Solve
        int GAP = nums.length % 2 == 0 ? nums.length : nums.length - 1;
        while (GAP > 0) {
            for (int i = 0; i + GAP <= nums.length; i++) {
                if (check(i, i + GAP)) {

                    // Output
                    System.out.println(GAP);
                    return;
                }
            }
            GAP -= 2;
        }
        System.out.println(0);
    }
}