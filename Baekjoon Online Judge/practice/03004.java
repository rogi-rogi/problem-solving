import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        
        // Solve
        int res = ((3+N)/2);
        res *= (2 + N)/2;
        
        // Output
        System.out.println(res);

    }
}
