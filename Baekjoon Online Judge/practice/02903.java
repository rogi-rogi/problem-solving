import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Input
        final int N = Integer.parseInt(br.readLine());
        
        // Solve
        int p = 1 + (int) Math.pow(2, N);
        
        // Output
        System.out.println((int) Math.pow(p, 2));
    }
}
