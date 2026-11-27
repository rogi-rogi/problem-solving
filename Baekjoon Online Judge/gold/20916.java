import java.io.*;
import java.util.*;

public class Main {
    static final int[] helloNums = {
            202021, 20202021, 202002021, 202012021,
            202022021, 202032021, 202042021, 202052021,
            202062021, 202072021, 202082021, 202092021
    };

    static int lowerBound(int[] arr, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    // upper_bound: first index where arr[idx] > target
    static int upperBound(int[] arr, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // Solve
            Arrays.sort(arr);

            long res = 0;
            for (int i = 0; i < N; ++i) {
                for (int helloNum : helloNums) {
                    int val = helloNum - arr[i];
                    int l = lowerBound(arr, val, i + 1, N);
                    int r = upperBound(arr, val, i + 1, N);
                    res += (r - l);
                }
            }
            sb.append(res).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}