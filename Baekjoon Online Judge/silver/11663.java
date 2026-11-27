import java.io.*;
import java.util.*;

public class Main {
    static int[] A;
    private static int upperBound(int target) {
        int start = 0, end = A.length;
        while (start < end) {
            final int mid = (start + end) >> 1;
            if (A[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
    private static int lowerBound(int target) {
        int start = 0, end = A.length;
        while (start < end) {
            final int mid = (start + end) >> 1;
            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[1]);
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        Arrays.sort(A);
        while (M-- > 0) {
            input = br.readLine().split(" ");
            sb.append(upperBound(Integer.parseInt(input[1])) - lowerBound(Integer.parseInt(input[0]))).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}