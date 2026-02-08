import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        List<BigInteger> f = new ArrayList();

        // Solve
        f.add(BigInteger.valueOf(0));
        f.add(BigInteger.valueOf(1));
        f.add(BigInteger.valueOf(1));
        for (int i = 3; i <= N; ++i) {
            f.add(f.get(i - 1).add(f.get(i - 2)));
        }

        // Output
        System.out.println(f.get(N));
    }
}