import java.io.*;
import java.util.*;

public class Main {
    private static int getMaxLength(List<Integer> list) {
        int max_len = 0;
        int prev = 0;
        for (Integer cur : list) {
            max_len = Math.max(max_len, cur - prev);
            prev = cur;
        }
        return max_len;
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int R = Integer.parseInt(input[0]);
        final int C = Integer.parseInt(input[1]);
        int N = Integer.parseInt(br.readLine());
        List<Integer> row_list = new ArrayList<>();
        List<Integer> col_list = new ArrayList<>();
        while (N-- > 0) {
            input = br.readLine().split(" ");
            if (input[0].equals("0")) {
                row_list.add(Integer.parseInt(input[1]));
            } else {
                col_list.add(Integer.parseInt(input[1]));
            }
        }

        // Solve
        row_list.add(C);
        col_list.add(R);
        Collections.sort(row_list);
        Collections.sort(col_list);
        int max_row = getMaxLength(row_list);
        int max_col = getMaxLength(col_list);

        // Output
        System.out.println(max_row * max_col);
    }
}
