import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        Set<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        set.add(st.nextToken());
        set.add(st.nextToken());
        st = new StringTokenizer(br.readLine());
        set.add(st.nextToken());
        set.add(st.nextToken());

        // Solve
        List<String> res = new ArrayList<>();
        for (String s1 : set) {
            for (String s2 : set) {
                res.add(s1 + " " + s2);
            }
        }
        res.sort(String::compareTo);

        // Output
        for (String re : res) {
            sb.append(re).append("\n");
        }
        System.out.println(sb);
    }
}