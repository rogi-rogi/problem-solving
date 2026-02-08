import java.io.*;
import java.util.*;

public class Main {
    static boolean isEqual = false;
    static int[] B;
    static int cur;
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        br.readLine();
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        if (!Arrays.equals(A, B)) {
            mergeSort(A, 0, A.length - 1);
        } else isEqual = true;

        // Output
        System.out.println(isEqual ? 1 : 0);
    }
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int l = left, r = mid + 1;
        int[] temp = new int[right - left + 1];
        int k = 0;
        while (l <= mid && r <= right) {
            temp[k++] = (arr[l] <= arr[r]) ? arr[l++] : arr[r++];
        }
        while (l <= mid)    temp[k++] = arr[l++];
        while (r <= right)  temp[k++] = arr[r++];

        // System.arraycopy(temp, 0, arr, left, temp.length);
        for (int i = left; i <= right; ++i) {
            arr[i] = temp[i - left];
            if (!isEqual) {
                while (cur < arr.length) {
                    if (arr[cur] != B[cur])
                        break;
                    ++cur;
                }
                if (cur == arr.length) isEqual = true;
            }
        }
    }
}
