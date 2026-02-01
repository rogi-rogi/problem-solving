import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Input
		String[] in =  br.readLine().split(" ");
		int W = Integer.parseInt(in[0]);
		int H = Integer.parseInt(in[1]);
		int R = Integer.parseInt(br.readLine());

		// Solve & Output
		System.out.print(W * H - Math.PI * Math.pow(R, 2) / 4);
	}
}
