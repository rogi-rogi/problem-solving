import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        while (N-- > 0) {
            set.add(br.readLine());
        }
        // Solve
        List<String> list = new ArrayList<>(set);
        list.sort((o1, o2) -> {
            if (o1.length() == o2.length())
                return o1.compareTo(o2);
            return Integer.compare(o1.length(), o2.length());
        });

        // Output
        System.out.println(String.join("\n", list));
    }
}