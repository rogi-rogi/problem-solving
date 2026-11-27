import java.io.*;
import java.util.*;

public class Main {
    private static int lowerBound(int[][] arr, int key) {
        int start = 0, end = arr.length;

        while (start < end) {
            final int mid = (start + end) / 2;
            if (arr[mid][0] >= key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int upperBound(int[][] arr, int key) {
        int start = 0, end = arr.length;

        while (start < end) {
            final int mid = (start + end) / 2;
            if (arr[mid][0] > key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] menu = new int[N][2];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            menu[i][0] = Integer.parseInt(st.nextToken());
            menu[i][1] = Integer.parseInt(st.nextToken());
        }

        // Solve
        Arrays.sort(menu, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int u = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());
            final int x = Integer.parseInt(st.nextToken());
            final int y = Integer.parseInt(st.nextToken());

            int s = lowerBound(menu, u);
            int e = upperBound(menu, v);

            int cnt = 0;
            for (int i = s; i < e; ++i) {
                if (menu[i][1] >= x && menu[i][1] <= y) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}