import java.io.*;
import java.math.BigInteger;

public class Main {
    private static BigInteger f(BigInteger n) {
        return n.multiply(n).multiply(BigInteger.valueOf(3)).add(n);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        BigInteger H = new BigInteger(br.readLine());
        BigInteger MOD = BigInteger.valueOf(8);

        // Solve
        while (!f(H).remainder(MOD).equals(BigInteger.ZERO)) {
            H = H.add(BigInteger.ONE);
        }

        // Output
        System.out.println(H);
    }
}
