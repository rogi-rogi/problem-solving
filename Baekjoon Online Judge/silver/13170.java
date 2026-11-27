import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final double P = Double.parseDouble(input[2]);
        final int W = Integer.parseInt(input[3]);

        // Solve
        final int cnt = (int) Math.ceil(P / W);

        // Output
        System.out.println(cnt);
    }
}