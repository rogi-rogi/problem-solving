import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int D = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // Solve
        String[] days = {"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};
        int[] dayOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int day = D;
        for (int i = 0; i < M; ++i) {
            day += dayOfMonth[i];
        }

        // Output
        System.out.println(days[day % 7]);
    }
}