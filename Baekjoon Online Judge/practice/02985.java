import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());

        // Solve
        sb.append(A);
        if (A == C - B) sb.append("+").append(B).append("=").append(C);
//        else if (A == C + B) sb.append("-").append(B).append("=").append(C);
        else if (A * B == C) sb.append("*").append(B).append("=").append(C);
//        else if (A == C * B) sb.append("/").append(B).append("=").append(C);
        else {
            sb.append("=").append(B);
            if (A == B + C) sb.append("+").append(C);
            else if (A == B - C) sb.append("-").append(C);
            else if (A == B * C) sb.append("*").append(C);
            else if (A == B / C) sb.append("/").append(C);
        }

        // Output
        System.out.println(sb.toString());
    }
}
