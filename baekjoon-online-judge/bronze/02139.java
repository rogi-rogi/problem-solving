import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        while (true) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (input[0] + input[1] + input[2] == 0) {
                break;
            }
            LocalDate date1 = LocalDate.of(input[2], 1, 1);
            LocalDate date2 = LocalDate.of(input[2], input[1], input[0]);

            // Solve & Output
            System.out.println(ChronoUnit.DAYS.between(date1, date2) + 1);
        }
    }
}