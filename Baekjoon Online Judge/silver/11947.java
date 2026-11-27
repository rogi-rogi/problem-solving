import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String strN = br.readLine();
            int N = Integer.parseInt(strN);

            // Solve
            long goodNum = 5 * (long) Math.pow(10, strN.length() - 1) - 1;
            if (N >= goodNum) {
                sb.append(goodNum * (goodNum + 1)).append("\n");
            } else {
                int origin = N;
                long digit = 1;
                long other = 0;
                while (N > 0) {
                    final long a = N % 10;
                    other += (9 - a) * digit;
                    digit *= 10;
                    N /= 10;
                }
                sb.append(origin * other).append("\n");
            }
        }

        // Output
        System.out.println(sb);
    }
}