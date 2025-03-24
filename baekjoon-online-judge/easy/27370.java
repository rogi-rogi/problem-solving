import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int Pa = Integer.parseInt(input[1]);
            int Pb = Integer.parseInt(input[2]);
            int[] X = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (Pa > Pb) {
                int temp = Pa;
                Pa = Pb;
                Pb = temp;
            }

            // Solve
            final int mid = (Pa + Pb) / 2;
            long A = 0, B = 0;
            int midCnt = 0;
            for (int x : X) {
                if (x < mid) A += (x - Pa);
                else if (x > mid) B += (Pb - x);
                else ++midCnt;
            }
            while (midCnt-- > 0) {
                if (A < B) A += (mid - Pa);
                else B += (Pb - mid);
            }
            sb.append(2*(A + B)).append(" ").append(2*Math.abs(A - B)).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}