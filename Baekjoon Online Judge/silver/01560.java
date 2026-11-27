import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		BigInteger n = new BigInteger(br.readLine());

		// Solve
		BigInteger result = n.add(n).subtract(BigInteger.valueOf(2));
		if (n.equals(BigInteger.ONE))
			result = BigInteger.ONE;

		// Output
		System.out.println(result);
	}
}