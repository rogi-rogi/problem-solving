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
        final int SIZE = str.length();
        List<String> strList = new ArrayList<>();
        for (int e = 2; e < SIZE; ++e) {
            for (int s = 1; s < e; ++s) {
                String firstPart = str.substring(0, s);
                String middlePart = str.substring(s, e);
                String lastPart = str.substring(e);
                strList.add(reverse(firstPart) + reverse(middlePart) + reverse(lastPart));
            }
        }
        Collections.sort(strList);
        
        // output
        System.out.println(strList.get(0));
    }
    private static String reverse(String str) {
        return (new StringBuilder(str)).reverse().toString();
    }
}
