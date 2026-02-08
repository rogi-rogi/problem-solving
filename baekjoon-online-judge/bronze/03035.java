import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        String[] input = br.readLine().split(" ");
        final int R = Integer.parseInt(input[0]);
        final int C = Integer.parseInt(input[1]);
        final int ZR = Integer.parseInt(input[2]);
        final int ZC = Integer.parseInt(input[3]);

        // Solve
        for (int r = 0; r < R; ++r) {
            char[] line = br.readLine().toCharArray();
            StringBuilder temp = new StringBuilder();
            for (char c : line) {
                for (int cnt = 0; cnt < ZC; ++cnt) {
                    temp.append(c);
                }
            }
            temp.append('\n');
            for (int cnt = 0; cnt < ZR; ++cnt) {
                sb.append(temp);
            }
        }

        // Output
        System.out.println(sb);
    }
}