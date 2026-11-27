import java.io.*;

public class Main {
    private static final Double PI = Math.acos(-1);

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int T = Integer.parseInt(br.readLine());

        double res = 0;
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            String type = input[0];
            double r = Double.parseDouble(input[1]);
            double h;
            // Solve
            if (type.equals("S")) {
                res = Math.max(res, PI * r * r * r * 4 / 3);
            } else {
                h = Double.parseDouble(input[2]);
                if (type.equals("C")) {
                    res = Math.max(res, PI * r * r * h / 3);
                } else {
                    res = Math.max(res, PI * r * r * h);
                }
            }
        }

        // Output
        System.out.printf("%.3f", res);
    }
}
