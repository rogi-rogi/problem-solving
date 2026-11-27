import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws IOException {
		// init & iunput
		BitSet nums = new BitSet(1 << 25);
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		StringBuilder sb = new StringBuilder();
		
		// soluction
		int SIZE = st.countTokens();
		while (SIZE-- > 0) {
		    int num = Integer.parseInt(st.nextToken());
		    if (!nums.get(num)) {
		        nums.set(num);
		        sb.append(num).append(' ');
		    }
		}
		
		// output
		System.out.println(sb.toString());
	}
}
