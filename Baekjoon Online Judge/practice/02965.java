import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Input
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());

        // Solve & Output
        System.out.println(Math.max(B - A, C - B) - 1);
    }
}
