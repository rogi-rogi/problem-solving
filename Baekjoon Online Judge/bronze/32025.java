import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print(
			50 * Math.min(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()))
		);
	}
}
