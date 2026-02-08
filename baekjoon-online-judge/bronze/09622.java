import java.io.*;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner("\n");

        // Input
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        String[] input;
        double height, width, deep, weight;
        while (N-- > 0) {
            input = br.readLine().replace("  ", " ").split(" ");
            height = Double.parseDouble(input[0]);
            width = Double.parseDouble(input[1]);
            deep = Double.parseDouble(input[2]);
            weight = Double.parseDouble(input[3]);

            // Solve
            if ((height > 56 || width > 45 || deep > 25) && (height + width + deep > 125) || weight > 7) {
                sj.add("0");
            } else {
                sj.add("1");
                ++cnt;
            }
        }
        sj.add(String.valueOf(cnt));

        // Output
        System.out.println(sj);
    }
}
