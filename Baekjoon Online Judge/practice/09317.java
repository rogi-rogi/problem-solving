import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        double[] input;
        while (true) {
            input = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double d = input[0];
            double Rh = input[1];
            double Rv = input[2];
            if (d == 0 && Rh == 0 && Rv == 0) {
                break;
            }
            double w = 16 * d / Math.sqrt(337);
            double h = w * 9 / 16;

            sb.append(String.format("Horizontal DPI: %.2f%n", Rh / w));
            sb.append(String.format("Vertical DPI: %.2f%n", Rv / h));
        }

        // Output
        System.out.println(sb);
    }
}
