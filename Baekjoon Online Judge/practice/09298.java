import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // Input
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; ++tc) {
            int N = Integer.parseInt(br.readLine());
            double[] X = new double[N];
            double[] Y = new double[N];
            double[] input;
            for (int i = 0; i < N; ++i) {
                input = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
                X[i] = input[0];
                Y[i] = input[1];
            }
            // Solve
            Arrays.sort(X);
            Arrays.sort(Y);

            double height = Y[N - 1] - Y[0];
            double width = X[N - 1] - X[0];

            sb.append(String.format("Case %d: Area %f, Perimeter %f%n", tc, height * width, 2 * (height + width)));
        }

        // Output
        System.out.println(sb);
    }
}
