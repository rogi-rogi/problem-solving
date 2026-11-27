import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // input
        String str = br.readLine();
        
        // solve
        String res = "z".repeat(50);
        final int SIZE = str.length();
        
        for (int e = 2; e < SIZE; ++e) {
            for (int s = 1; s < e; ++s) {
                StringBuilder newStr = new StringBuilder();
                String[] subStr = new String[] {
                    str.substring(0, s),
                    str.substring(s, e),
                    str.substring(e)
                };
                for (int i = 0; i < 3; ++i)
                    newStr.append(new StringBuilder(subStr[i]).reverse());
                    
                if (newStr.toString().compareTo(res) < 0) {
                    res = newStr.toString();
                }
            }
        }
        
        // output
        System.out.println(res);
    }
}
