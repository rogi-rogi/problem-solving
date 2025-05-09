import java.io.*;
import java.util.*;

public class Main {
    private static boolean isValid(int[] A) {
        for (int i : A) {
            if (i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());

        // Solve
        int[] arr = new int[N];
        Arrays.fill(arr, K);
        int day = 0;
        Arrays.sort(arr);
        while (isValid(arr)) {
            for (int i = 0; i < A; ++i) {
                arr[i] += B - 1;
            }
            for (int i = A; i < arr.length; ++i) {
                arr[i] -= 1;
            }
            Arrays.sort(arr);
            ++day;
        }

        // Output
        System.out.println(day);
    }
}
