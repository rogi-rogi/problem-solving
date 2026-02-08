import java.io.*;
import java.time.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        LocalTime start = LocalTime.parse(br.readLine());
        LocalTime end = LocalTime.parse(br.readLine());

        // Solve
        int totalSec = (int) Duration.between(start, end).getSeconds();
        if (totalSec < 0) {
            totalSec += 24 * 3600;
        }
        final int H = totalSec / 3600;
        final int M = (totalSec % 3600) / 60;
        final int S = totalSec % 60;

        // Output
        System.out.printf("%02d:%02d:%02d", H, M, S);
    }
}