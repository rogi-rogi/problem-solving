import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException{
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// input
		int N = Integer.parseInt(br.readLine());
		
		// solve
		{
	        int depth = 1;
    	    while (N > depth) {
    	        N -= depth;
    	        ++depth;
    	    }
    	    
    	    int numerator, denominator;
    	    if (depth % 2 == 0) {
    	        numerator = N;
    	        denominator = depth - N + 1;
    	    } else {
    	        numerator = depth - N + 1;
    	        denominator = N;
    	    }
    	    
    	    sb.append(numerator).append('/').append(denominator);
	    }
	    
	    // output
	    System.out.println(sb.toString());
	}
}
