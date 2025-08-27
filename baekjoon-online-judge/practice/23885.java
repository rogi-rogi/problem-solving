import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Input
        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        final int sX = Integer.parseInt(st.nextToken());
        final int sY = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        final int eX = Integer.parseInt(st.nextToken());
        final int eY = Integer.parseInt(st.nextToken());

        // Solve & Output
        if ((sX != eX || sY != eY) && (N == 1 || M == 1)) {
            System.out.println("NO");
        } else {
            System.out.println((sX + sY) % 2 == (eX + eY) % 2 ? "YES" : "NO");
        }
    }
}