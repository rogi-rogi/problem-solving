import java.io.*;
import java.util.Arrays;

public class Main {
    private static boolean nextPermutation(int[] arr) {
        int N = arr.length;
        int i = N - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) --i;
        if (i == 0) return false;
        int j = N - 1;
        while (arr[i - 1] >= arr[j]) --j;
        swap(i - 1, j, arr);
        j = N - 1;
        while (i < j) swap(i++, j--, arr);
        return true;
    }
  
    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  
    public static int f(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length - 1; ++i) {
            res += Math.abs(arr[i] - arr[i + 1]);
        }
        return res;
    }
  
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        // Solve
        int res = 0;
        do  {
            res = Math.max(res, f(arr));
        } while (nextPermutation(arr));
        
        // Output
        System.out.println(res);
    }
}
