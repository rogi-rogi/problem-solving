import java.io.*;
import java.util.*;

public class Main {
    private static long hexToDecimal(char[] hex, int start, int end) {
        long res = 0, q = 1;
        for (int i = end, num; i >= start; i--) {
            num = hex[i] <= '9' ? hex[i] - '0' : 10 + hex[i] - 'a';
            res += q * num;
            q <<= 4;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        char[] hex = br.readLine().toCharArray();
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Solve
        int idx = 0;
        while (st.hasMoreTokens()) {
            switch (st.nextToken()) {
                case "char":
                    sb.append(hexToDecimal(hex, idx, idx + 1)).append(" ");
                    idx += 2;
                    break;
                case "int":
                    sb.append(hexToDecimal(hex, idx, idx + 7)).append(" ");
                    idx += 8;
                    break;
                case "long_long":
                    sb.append(hexToDecimal(hex, idx, idx + 15)).append(" ");
                    idx += 16;
                    break;
            }
        }

        // Output
        System.out.println(sb);
    }
}