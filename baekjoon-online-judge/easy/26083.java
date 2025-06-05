import java.io.*;
import java.util.*;

public class Main {
    static int todayInt;
    static int toIntDate(int y, int m, int d) {
        return y * 10000 + m * 100 + d;
    }
    static boolean isValid(int y, int m, int d) {
        if (y < 2000 || y > 2099) return false;
        if (m < 1 || m > 12) return false;
        if (d < 1) return false;

        int[] daysInMonth = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        if (m == 2 && isLeapYear(y)) {
            return d <= 29;
        }

        return d <= daysInMonth[m - 1];
    }
    static boolean isLeapYear(int y) {
        return y % 4 == 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int y = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());
        final int d = Integer.parseInt(st.nextToken());
        todayInt = toIntDate(2000 + y, m, d);

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            List<Integer> validDates = new ArrayList<>();

            if (isValid(2000 + A, B, C)) validDates.add(toIntDate(2000 + A, B, C)); // Y/M/D
            if (isValid(2000 + C, B, A)) validDates.add(toIntDate(2000 + C, B, A)); // D/M/Y
            if (isValid(2000 + C, A, B)) validDates.add(toIntDate(2000 + C, A, B)); // M/D/Y

            if (validDates.isEmpty()) {
                sb.append("invalid\n");
            } else if (validDates.stream().allMatch(date -> date >= todayInt)) {
                sb.append("safe\n");
            } else {
                sb.append("unsafe\n");
            }
        }

        // Output
        System.out.print(sb);
    }
}
