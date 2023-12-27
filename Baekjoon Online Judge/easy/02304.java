import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;

        // Input
        int N = Integer.parseInt(br.readLine());
        final int SIZE = 1001;
        int[] arr = new int[SIZE];
        int divL = 0;
        for (int i = 0, maxH = 0, L, H; i < N; ++i) {
            line = br.readLine().split(" ");
            L = Integer.parseInt(line[0]);
            H = Integer.parseInt(line[1]);
            arr[L] = H;
            if (H > maxH) {
                maxH = H;
                divL = L;
            }
        }

        // Solve
        int curH = 0, res = 0;
        for (int i = 0; i <= divL; ++i) {
            if (arr[i] > curH) {
                curH = arr[i];
            }
            res += curH;
        }

        curH = 0;
        for (int i = SIZE - 1; i > divL; --i) {
            if (arr[i] > curH) {
                curH = arr[i];
            }
            res += curH;
        }

        // Output
        System.out.println(res);
    }
}
