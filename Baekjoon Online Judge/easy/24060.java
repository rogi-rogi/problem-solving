import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0, K, res = -1;
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        K = Integer.parseInt(br.readLine().split(" ")[1]);
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        mergeSort(A, 0, A.length - 1);

        // Output
        System.out.println(res);
    }
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr,
                Arrays.copyOfRange(arr, left, mid + 1),
                Arrays.copyOfRange(arr, mid + 1, right + 1),
                left);
    }
    private static void merge(int[] arr, int[] left, int[] right, int k) {
        int l = 0, r = 0;
        while (l < left.length && r < right.length) {
            arr[k++] = (left[l] <= right[r]) ? left[l++] : right[r++];
            if (++cnt == K) res = arr[k - 1];
        }
        while (l < left.length) {
            arr[k++] = left[l++];
            if (++cnt == K) res = arr[k - 1];
        }
        while (r < right.length) {
            arr[k++] = right[r++];
            if (++cnt == K) res = arr[k - 1];
        }
    }
}
