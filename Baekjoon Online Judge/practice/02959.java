import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        for (int i = 0; i < 4; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Solve & Output
        Arrays.sort(arr);
        System.out.println(arr[0] * arr[2]);
    }
}
