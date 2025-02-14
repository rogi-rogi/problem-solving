import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            // Solve
            int minEvenNum = 100;
            int sumEvenNum = 0;
            for (int i = 0, num; i < 7; ++i) {
                num = Integer.parseInt(st.nextToken());
                if (num % 2 == 0) {
                    sumEvenNum += num;
                    if (num < minEvenNum)
                        minEvenNum = num;
                }
            }
            sb.append(sumEvenNum).append(" ").append(minEvenNum).append("\n");
        }

        // Output
        System.out.println(sb.toString());
    }
}
