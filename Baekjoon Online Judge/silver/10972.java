import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;

    private static boolean findNextPermutation() {
        int idx = N - 1;
        while (idx > 0 && nums[idx - 1] > nums[idx]) --idx;
        if (idx <= 0) return false;
        int cur = N - 1;
        while (nums[idx - 1] > nums[cur]) --cur;
        swap(idx - 1, cur);
        cur = N - 1;
        while (idx < cur) swap(idx++, cur--);
        return true;
    }

    private static void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        if (findNextPermutation()) {
            for (int i : nums)
                sb.append(i).append(' ');
        } else {
            sb.append(-1);
        }

        // Output
        System.out.println(sb);
    }
}
