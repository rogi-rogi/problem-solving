import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] in = br.readLine().split(" ");
        int X1 = Integer.parseInt(in[0]);
        int Y1 = Integer.parseInt(in[1]);
        int N = Integer.parseInt(br.readLine());

        int distance = Integer.MAX_VALUE;
        int resultX = -1, resultY = -1;
        while (N-- > 0) {
            in = br.readLine().split(" ");
            int X2 = Integer.parseInt(in[0]);
            int Y2 = Integer.parseInt(in[1]);

            // Solve
            if (Math.abs(X2-X1) + Math.abs(Y2-Y1) < distance) {
                resultX = X2;
                resultY = Y2;
                distance = Math.abs(X2-X1) + Math.abs(Y2-Y1);
            }
        }

        // Output
        System.out.println(resultX + " " + resultY);
    }
}