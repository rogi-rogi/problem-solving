import java.io.*;
import java.util.*;

public class Main {
    private static List<String> getSuffixes(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> suffixes = new ArrayList<>();
        for (int i = s.length() -1; i >= 0; --i) {
            sb.append(s.charAt(i));
            suffixes.add(sb.toString());
        }
        return suffixes;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        Set<String> xorSet = new HashSet<>();
        while (N-- > 0) {

            // Solve
            for (String suffix : getSuffixes(br.readLine())) {
                if (!xorSet.add(suffix)) {
                    xorSet.remove(suffix);
                }
            }
        }

        // Output
        System.out.println(xorSet.size());
    }
}